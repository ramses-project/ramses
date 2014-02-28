package fr.tpt.aadl.ramses.analysis.eg.model;

import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;

public enum OP_KIND {
	ADD, SUB, MUL, DIV, MOD, AND, OR, NOT, MUTEX, JMP, LOAD, STORE, NONE, 
	EQUAL, NOT_EQUAL, LESS_THAN, LESS_OR_EQUAL_THAN, GREATER_THAN, GREATER_OR_EQUAL_THAN,
	NEGATIVE, POSITIVE;
	
	public boolean isUnaryOperator()
	{
	  return this == NEGATIVE || this == POSITIVE || this == NOT;
	}
	
	public static OP_KIND convert(LogicalOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			case AND:  return AND;
			case OR:   return OR;
			default:   return NYI(op);
		}
	}
	public static OP_KIND convert(RelationalOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			case EQUAL: return EQUAL;
			case NOT_EQUAL: return NOT_EQUAL;
			case LESS_THAN: return LESS_THAN;
			case LESS_OR_EQUAL_THAN: return LESS_OR_EQUAL_THAN;
			case GREATER_THAN: return GREATER_THAN;
			case GREATER_OR_EQUAL_THAN: return GREATER_OR_EQUAL_THAN;
			default: return NYI(op);
		}
	}
	public static OP_KIND convert(UnaryAddingOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			case PLUS: return POSITIVE;
			case MINUS: return NEGATIVE;
			default: return NYI(op);
		}
	}
	public static OP_KIND convert(BinaryAddingOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			case PLUS: return ADD;
			case MINUS: return SUB;
			default: return NYI(op);
		}
	}
	public static OP_KIND convert(MultiplyingOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			case MULTIPLY: return MUL;
			case DIVIDE: return DIV;
			case MOD: return MOD;
			default: return NYI(op);
		}
	}
	public static OP_KIND convert(UnaryBooleanOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			case NOT: return NOT;
			default: return NYI(op);
		}
	}
	public static OP_KIND convert(UnaryNumericOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			default: return NYI(op);
		}
	}
	public static OP_KIND convert(BinaryNumericOperator op)
	{
		switch (op)
		{
			case NONE: return NONE;
			default: return NYI(op);
		}
	}
	
	private static OP_KIND NYI(Enum<?> e)
	{
		System.err.println("Not yet supported: " + e.name());
		return NONE;
	}
};
