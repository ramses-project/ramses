/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.analysis.eg.ba;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataPrototype ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorBooleanLiteral ;
import org.osate.ba.aadlba.BehaviorEnumerationLiteral ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorVariable ;
import org.osate.ba.aadlba.BehaviorVariableHolder ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.DataAccessHolder ;
import org.osate.ba.aadlba.DataComponentReference ;
import org.osate.ba.aadlba.DataHolder ;
import org.osate.ba.aadlba.DataSubcomponentHolder ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.ParameterHolder ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueExpression ;

import fr.tpt.aadl.ramses.analysis.eg.context.EGContext ;
import fr.tpt.aadl.ramses.analysis.eg.context.SubprogramCallContext ;
import fr.tpt.aadl.ramses.analysis.eg.model.IOTime ;
import fr.tpt.aadl.ramses.analysis.eg.model.OP_KIND ;
import fr.tpt.aadl.ramses.analysis.eg.model.SystemProperties ;
import fr.tpt.aadl.ramses.analysis.eg.util.DataClassifierUtil ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class ValueExpressionUtil {
  
  private static final EGContext ctxt = EGContext.getInstance();
  
  private static Logger _LOGGER = Logger.getLogger(ValueExpressionUtil.class) ;

	private ValueExpressionUtil(){}
	
	public static List<ExpressionTokens> decompose (ValueExpression ve,
	                                                boolean isSubprogramInputParameter,
	                                                boolean copyTarget)
	{
	  return new ExpressionTokens (getTokens (ve,copyTarget),
	                               isSubprogramInputParameter).decompose(copyTarget);
	}
	
	private static List<ExpressionToken> getTokens(ValueExpression ve, boolean copyTarget) 
	{
		final List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		final List<LogicalOperator> loperators = ve.getLogicalOperators();
		final int relationCount = ve.getRelations().size();
		
		int indexLOperator = 0;
		for(int indexRel=0;indexRel<relationCount;indexRel++)
		{
			Relation r = ve.getRelations().get(indexRel);
			List<ExpressionToken> relTokens = getTokens(r, copyTarget);
			
			tokens.addAll(relTokens);
			if (indexRel < relationCount-1)
			{
				LogicalOperator op = loperators.get(indexLOperator);
				OP_KIND op_ = OP_KIND.convert(op);
				tokens.add(new OperatorToken(op_));
				indexLOperator++;
			}
		}
		return tokens;
	}
	
	private static List<ExpressionToken> getTokens(Relation r, boolean copyTarget)
	{
		List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		tokens.addAll(getTokens(r.getFirstExpression(),copyTarget));
		if (r.isSetRelationalOperator())
		{
			RelationalOperator op = r.getRelationalOperator();
			OP_KIND op_ = OP_KIND.convert(op);
			tokens.add(new OperatorToken(op_));
			tokens.addAll(getTokens(r.getSecondExpression(),copyTarget));
		}
		return tokens;
	}

	private static List<ExpressionToken> getTokens(
			SimpleExpression se,boolean copyTarget) 
	{
		final List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		final List<BinaryAddingOperator> boperators = se.getBinaryAddingOperators();
		final List<Term> terms = se.getTerms();
		
		int indexBoperator = 0;
		
		if (se.isSetUnaryAddingOperator())
		{
			UnaryAddingOperator op = se.getUnaryAddingOperator();
			OP_KIND op_ = OP_KIND.convert(op);
			tokens.add(new OperatorToken(op_));
		}
		
		final int termCount = terms.size();
		for(int iTerm=0;iTerm<termCount;iTerm++)
		{
			Term t = terms.get(iTerm);
			tokens.addAll(getTokens(t,copyTarget));
			
			if (iTerm < termCount-1)
			{
				BinaryAddingOperator op = boperators.get(indexBoperator);
				OP_KIND op_ = OP_KIND.convert(op);
				tokens.add(new OperatorToken(op_));
				indexBoperator++;
			}
		}
		
		return tokens;
	}
	
	private static List<ExpressionToken> getTokens(Term t, boolean copyTarget)
	{
		final List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		final List<Factor> factors = t.getFactors();
		final List<MultiplyingOperator> moperators = t.getMultiplyingOperators();
		
		int indexMOperator = 0;
		
		final int factorCount = factors.size(); 
		for(int iFactor=0;iFactor<factorCount;iFactor++)
		{
			tokens.addAll(getTokens(factors.get(iFactor),copyTarget));
			
			if (iFactor < factorCount-1)
			{
				MultiplyingOperator op = moperators.get(indexMOperator);
				OP_KIND op_ = OP_KIND.convert(op);
				tokens.add(new OperatorToken(op_));
				indexMOperator++;
			}
		}
		
		return tokens;
	}
	
	private static List<ExpressionToken> getTokens(Factor f, boolean copyTarget)
	{
		final List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		if (f.isSetUnaryBooleanOperator())
		{
			UnaryBooleanOperator op = f.getUnaryBooleanOperator();
			OP_KIND op_ = OP_KIND.convert(op);
			tokens.add(new OperatorToken(op_));
		}
		if (f.isSetUnaryNumericOperator())
		{
			UnaryNumericOperator op = f.getUnaryNumericOperator();
			OP_KIND op_ = OP_KIND.convert(op);
			tokens.add(new OperatorToken(op_));
		}
		
		tokens.addAll(getTokensValue(f.getFirstValue(),copyTarget));
		if (f.isSetBinaryNumericOperator())
		{
			BinaryNumericOperator op = f.getBinaryNumericOperator();
			OP_KIND op_ = OP_KIND.convert(op);
			tokens.add(new OperatorToken(op_));
			tokens.addAll(getTokensValue(f.getSecondValue(),copyTarget));
		}
		
		return tokens;
	}
	
	private static List<ExpressionToken> getTokensValue(Value v, boolean copyTarget)
	{
		if (v instanceof ValueExpression)
		{
			return getTokens((ValueExpression) v, copyTarget);
		}
		else if (v instanceof DataComponentReference)
		{
			return getTokens((DataComponentReference) v, copyTarget);
		}
		else if (v instanceof BehaviorEnumerationLiteral)
		{
		  return getTokens((BehaviorEnumerationLiteral) v, copyTarget);
		}
		else if (v instanceof BehaviorIntegerLiteral)
		{
		  return getTokens((BehaviorIntegerLiteral) v, copyTarget);
		}
		else if (v instanceof BehaviorBooleanLiteral)
		{
		  return getTokens((BehaviorBooleanLiteral) v, copyTarget);
		}
		else if (v instanceof DataHolder)
		{
		  return getTokensHolder((DataHolder) v, copyTarget);
		}
		else
		{
		  String msg = "Cannot get tokens for expression of type \'" + 
                    v.getClass().getSimpleName() + '\'' ;
		  _LOGGER.error(msg) ;
		  ServiceProvider.SYS_ERR_REP.error(msg, true);
			return Collections.emptyList();
		}
	}
	
	private static List<ExpressionToken> getTokens(DataComponentReference r, boolean copyTarget)
	{
		final List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		List<DataHolder> dataHolders = r.getData();
		for(DataHolder h : dataHolders)
		{
		  tokens.addAll(getTokensHolder(h,copyTarget));
		}
		return tokens;
	}
	
	private static List<ExpressionToken> getTokensHolder (DataHolder h, boolean copyTarget)
	{
	  if (h instanceof ParameterHolder)
	  {
	    return getTokens ((ParameterHolder) h, copyTarget);
	  }
	  else if (h instanceof DataSubcomponentHolder)
    {
      return getTokens((DataSubcomponentHolder) h, copyTarget);
    }
	  else if (h instanceof DataAccessHolder)
	  {
	    return getTokens((DataAccessHolder) h, copyTarget);
	  }
	  else if (h instanceof BehaviorVariableHolder)
	  {
	    return getTokens ((BehaviorVariableHolder) h, copyTarget);
	  }
	  else
    {
	    String msg = "Cannot get tokens for holder of type \'" 
          + h.getClass().getSimpleName() + '\'' ;
	    _LOGGER.error(msg) ;
	    ServiceProvider.SYS_ERR_REP.error(msg, true);
      return Collections.emptyList();
    }
	}
	
	private static List<ExpressionToken> getTokens(ParameterHolder h, boolean copyTarget)
	{
	  List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
	  Parameter p = h.getParameter();
	  DataSubcomponentType dst = p.getDataFeatureClassifier();
	  //DataClassifier dc = (DataClassifier) p.getDataFeatureClassifier();
	  DataClassifier dc = ctxt.getCurrentVisitedSubprogram().resolveClassifier(dst);
	  
	  tokens.add(new DataToken("Parameter_"+p.getName(),dc));
	  return tokens;
	}
	
	private static List<ExpressionToken> getTokens (DataSubcomponentHolder h, boolean copyTarget)
	{
	  final List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
	  DataClassifier dc = null;
	  DataSubcomponent ds = (DataSubcomponent) h.getElement();
    DataSubcomponentType dst = ds.getDataSubcomponentType();
    if (dst instanceof DataClassifier)
    {
      dc = (DataClassifier) dst;
    }
    else if (dst instanceof DataPrototype)
    {
      SubprogramCallContext scc = ctxt.getCurrentVisitedSubprogram();
      dc = scc.resolvePrototype((DataPrototype) dst);
    }
    else
    {
      String msg = "DataSubcomponentHolder: cannot get tokens for \'" + dst +
                   '\'' ;
      _LOGGER.error(msg) ;
      ServiceProvider.SYS_ERR_REP.error(msg, true);
    }
    
    tokens.add (new DataToken (h.getElement().getName(),dc));
    
    List<IntegerValue> indices = h.getArrayIndexes();
    if (indices != null && !indices.isEmpty())
    {
      for(IntegerValue indice : indices)
      {
        if (indice instanceof DataHolder)
        {
          tokens.addAll(getTokensHolder((DataHolder) indice, copyTarget));
        }
        else if (indice instanceof DataComponentReference)
        {
          tokens.addAll(getTokens((DataComponentReference) indice, copyTarget));
        }
        else
        {
          String msg = "DataSubcomponentHolder indice: cannot get tokens for " +
                       indice + '\'' ;
          _LOGGER.error(msg) ;
          ServiceProvider.SYS_ERR_REP.error(msg, true);
        }
      }
    }
    
    return tokens;
	}
	
	private static List<ExpressionToken> getTokens(DataAccessHolder h, boolean copyTarget)
	{
	  List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
	  DataAccess da = h.getDataAccess();
    DataSubcomponentType dst = da.getDataFeatureClassifier();
    DataClassifier dc = ctxt.getCurrentVisitedSubprogram().resolveClassifier(dst);
    tokens.add(new DataAccessToken("DataAccessValue_" + h.getDataAccess().getName(),dc));
	  return tokens;
	}
	
	private static List<ExpressionToken> getTokens(BehaviorEnumerationLiteral v, boolean copyTarget)
  {
	  List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
	  tokens.add(new DataToken("Literal_"+v.getEnumLiteral().getValue(),1));
	  return tokens;
  }
	
	private static List<ExpressionToken> getTokens(BehaviorIntegerLiteral v, boolean copyTarget)
  {
    List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
    tokens.add(new DataToken("Literal_"+v.getValue(),1));
    return tokens;
  }
	
	private static List<ExpressionToken> getTokens(BehaviorBooleanLiteral l ,boolean copyTarget)
	{
	  List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
    tokens.add(new DataToken("Literal_"+l.getValue(),0));
    return tokens;
	}
	
	private static List<ExpressionToken> getTokens(BehaviorVariableHolder h, boolean copyTarget)
	{
	  List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
	  BehaviorVariable v = h.getBehaviorVariable();
    tokens.add(new DataToken(v.getName(),v.getDataClassifier()));
    return tokens;
	}

  public static class ExpressionTokens
	{
		private List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		/*private final List<OperatorToken> operators = new ArrayList<OperatorToken>();
		private final List<DataToken> data = new ArrayList<DataToken>();*/
		
		private final boolean isSubprogramInputParameter;
		
		public ExpressionTokens(List<ExpressionToken> tokens, 
		                        boolean isSubprogramInputParameter)
		{
		  this.isSubprogramInputParameter = isSubprogramInputParameter;
			for(int i=0;i<tokens.size();i++)
			{
				ExpressionToken t = tokens.get(i);
				if (t instanceof OperatorToken)
				{
					OperatorToken ot = (OperatorToken) t;
					if (!ot.kind.isUnaryOperator())
					{
					  this.tokens.add(ot);
					}
					else
					{
					  // _LOGGER.trace ?
					  //System.out.println("Ignore unary operator: " + ot.getName());
					}
				}
				else
				{
				  this.tokens.add(t);
				}
			}
		}
		
		public List<ExpressionToken> getTokens()
		{
			return tokens;
		}
		
		/*
	   * A = B op1 C op2 D op3 E
	   * BC = B op1 C
	   * BCD = BC op2 D
	   * A = BCD op3 E
	   * 
	   * => même nombre d'opérateurs
	   * => nombre d'affectations = nombre d'opérandes
	   */
		
		private void mergeFields(boolean isSubprogramInputParameter, boolean copyTarget)
		{
		  List<ExpressionToken> newTokens = new ArrayList<ExpressionToken>();
		  int firstData = -1;
		  int lastData = -1;
		  for(int i=0;i<tokens.size();i++)
      {
        ExpressionToken t = tokens.get(i);
        if (t instanceof DataToken)
        {
          if (firstData == -1) firstData = i;
          else lastData = i;
        }
        else
        {
          if (firstData != -1 && lastData == -1)
          {
            newTokens.add(tokens.get(i-1));
          }
          else if (firstData != -1 && lastData != -1)
          {
            newTokens.add(DataToken.mergeFields(tokens.subList(firstData, lastData),
                                                isSubprogramInputParameter,
                                                copyTarget));
          }
          
          newTokens.add(t);
          firstData = -1;
          lastData = -1;
        }
      }
		  
		  if (firstData != -1 && lastData == -1)
      {
        newTokens.add(tokens.get(firstData));
      }
      else if (firstData != -1 && lastData != -1)
      {
        newTokens.add(DataToken.mergeFields(tokens.subList(firstData, lastData),
                                            isSubprogramInputParameter,copyTarget));
      }
		  
		  tokens = newTokens;
		}
		
		public List<ExpressionTokens> decompose(boolean copyTarget)
		{
			List<ExpressionTokens> subs = new ArrayList<ExpressionTokens>();
			List<ExpressionToken> current = new ArrayList<ExpressionToken>();
			
			mergeFields(isSubprogramInputParameter,copyTarget);
			
			int countData = 0;
			for(int i=0;i<tokens.size();i++)
			{
				/** current est complète quand elle contient deux data */
				ExpressionToken t = tokens.get(i);
				current.add(t);
				if (t instanceof DataToken)
				{
					countData++;
				}
				else if (t instanceof OperatorToken && countData == 0)
				{
				  /*current = new ArrayList<ExpressionToken>();
				  current.add(t);
				  subs.add(new ExpressionTokens(current));*/
				  current = new ArrayList<ExpressionToken>();
				}
				if ((countData == 2) || (tokens.size()==1))
				{
					subs.add(new ExpressionTokens(current,isSubprogramInputParameter));
					current = new ArrayList<ExpressionToken>();
					countData = 0;
				}
			}
			
			return subs;
		}
		
		public String toString()
		{
			String s = "";
			for(ExpressionToken e : tokens)
			{
				s = s + e.toString() + " ";
			}
			return s.trim();
		}
	}
	
	public static abstract class ExpressionToken
	{
		private final String name;
		
		protected final SystemProperties props = 
				EGContext.getInstance().getSystemProperties();
		
		public ExpressionToken(String name)
		{
			this.name = name;
		}
		public String getName()
		{
			return name;
		}
		
		public String toString()
		{
			return name;
		}
		
		public abstract long getSizeInOctets(ComponentInstance thread);
		
		public double getLoadTimeInMs(ComponentInstance thread)
		{
			IOTime io = props.getAssignTimeInMs(thread);
			return io.getTime(getSizeInOctets(thread));
		}
	}
	
	public static class DataToken extends ExpressionToken
	{
		//private final DataClassifier dc;
		private final long size;
		
		public DataToken(String name, long size)
		{
		  super(name);
		  this.size = size;
		}
		
		public DataToken(String name, DataClassifier dc) 
		{
			super(name);
			this.size = DataClassifierUtil.getOrComputeDataSize(dc);
			//String namedc = (dc==null ? "" : dc.getName());
			//System.out.println("DataToken " + name + "\t" + namedc + "\t"+size);
		}
		
		public long getSizeInOctets(ComponentInstance thread)
		{
			return size;
		}
		public double getReadTimeInMs(ComponentInstance thread)
		{
			IOTime io = props.getReadTimeInMs(thread);
			return io.getTime(getSizeInOctets(thread));
		}
		public double getWriteTimeInMs(ComponentInstance thread)
		{
			IOTime io = props.getWriteTimeInMs(thread);
			return io.getTime(getSizeInOctets(thread));
		}
		
		public static DataToken mergeFields (List<ExpressionToken> tokens, 
		                                     boolean isSubprogramInputParameter,
		                                     boolean copyTarget)
		{
		  String name = "";
		  
		  long size = 0;
		  if (isSubprogramInputParameter)
		  {
		    //If is a struct passed in parameter -> copy all the struct
		    //for(ExpressionToken t : tokens)
		    for(int i=0;i<tokens.size();i++)
	      {
		      ExpressionToken t = tokens.get(i);
	        DataToken dt = (DataToken) t;
	        
	        size += dt.size;
	      }
		  }
		  else
		  {
		    //If is a struct contained in a expression -> copy the last element
		    //(address resolved at compilation)
		    
		    DataToken dt = (DataToken) tokens.get(tokens.size()-1);
		    long t_size = dt.size;
		    
		    /** Do not copy DataAccessToken if not copyTarget */
        if ((dt instanceof DataAccessToken) && !copyTarget)
        {
          t_size = 0;
        }
        
        size = t_size;
		  }
		  
		  for(ExpressionToken dt : tokens)
		  {
		    name = name + dt.getName() + "_";
		  }
		  return new DataToken (name.substring(0,name.length()-1), size);
		}
	}
	
	public static class DataAccessToken extends DataToken
	{
    public DataAccessToken(String name, DataClassifier dc)
    {
      super(name, dc) ;
    }
	}
	
	public static class OperatorToken extends ExpressionToken
	{
		private final OP_KIND kind;
		
		public OperatorToken(OP_KIND kind)
		{
			super(kind.name());
			this.kind = kind;
		}
		
		public long getSizeInOctets(ComponentInstance thread)
		{
			return props.getWordSizeInOctets(thread);
		}
		public double getExecutionTime(ComponentInstance thread)
		{
			return props.getOperationMs(kind);
		}
	}
}