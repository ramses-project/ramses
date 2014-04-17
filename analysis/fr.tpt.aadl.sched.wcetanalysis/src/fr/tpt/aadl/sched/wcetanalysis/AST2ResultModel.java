package fr.tpt.aadl.sched.wcetanalysis;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Property;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import fr.tpt.aadl.ramses.util.properties.AadlUtil;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaFactory;
import fr.tpt.aadl.sched.wcetanalysis.util.Aadl2ASTUtil;
import fr.tpt.aadl.sched.wcetanalysis.util.SequenceUtil;

public class AST2ResultModel {

	private ExtractionContext ctxt;
	private final double factor;
	
	private final SystemInstance s;
	
	public AST2ResultModel(SystemInstance s, ExtractionContext ctxt)
	{
		this.ctxt = ctxt;
		this.s = s;
		this.factor = computeFactor(s);
	}
	
	private double computeFactor(SystemInstance s)
	{
		for(ComponentInstance c : s.getAllComponentInstances())
		{
			if (c.getCategory() == ComponentCategory.THREAD)
			{
				double wcet = ctxt.getAST(c).getWCET();
				if (((int)wcet) != wcet)
				{
					return 10d;
				}
			}
		}
		return 1d;
	}
	
	public AnalysisModel getAnalysisModel()
	{
		ReducedbaFactory factory = ReducedbaFactory.eINSTANCE;
		AnalysisModel m = factory.createAnalysisModel();
		for(ComponentInstance ci : s.getAllComponentInstances())
		{
			if (ci.getCategory() == ComponentCategory.THREAD) 
			{
				TaskBody tb = ctxt.getAST(ci);
				ReducedThreadBA reducedba = getReducedBA(tb);
				m.getThreadsBA().add(reducedba);
			}
		}
		return m;
	}
	
	private ReducedThreadBA getReducedBA(TaskBody body)
	{
		ReducedbaFactory factory = ReducedbaFactory.eINSTANCE; 
		ReducedThreadBA bamodel = factory.createReducedThreadBA();
		
		bamodel.setThread(body.getTask());
		
		ASTNode node = body.getReducedMainLoopAST();
		System.out.println("Reduced BA for " + body.getTask().getName());
		while (node != null)
		{
			System.out.println(node.getType());
			
			if (node.getType()==StatementKind.GetResource)
			{
				CriticalSectionBegin csBegin = factory.createCriticalSectionBegin();
				ComponentInstance ci = body.getTask();
				for(FeatureInstance fi: ci.getFeatureInstances())
				{
					if(fi.getCategory() == FeatureCategory.DATA_ACCESS
							&& fi.getFeature().getName().equals(node.getResourceID()))
						csBegin.setSharedData((DataAccess)fi.getFeature());
				}
				bamodel.getElements().add(csBegin);
			}
			else if (node.getType()==StatementKind.ReleaseResource)
			{
				CriticalSectionEnd csEnd = factory.createCriticalSectionEnd();
				ComponentInstance ci = body.getTask();
				for(FeatureInstance fi: ci.getFeatureInstances())
				{
					if(fi.getCategory() == FeatureCategory.DATA_ACCESS
							&& fi.getFeature().getName().equals(node.getResourceID()))
						csEnd.setSharedData((DataAccess)fi.getFeature());
				}
				bamodel.getElements().add(csEnd);
			}
			else
			{
				Computation comp = factory.createComputation();
				double bcet = node.getMinExecutionTime();
				double wcet = node.getMaxExecutionTime();
				
				String precision = AadlUtil.getPrecision(body.getTask());
				
				comp.setMin(bcet);
				comp.setMax(wcet);
				comp.setUnit(precision);
				
				bamodel.getElements().add(comp);
			}
			node = SequenceUtil.next(node);
		}
		
		return bamodel;
	}
	
}
