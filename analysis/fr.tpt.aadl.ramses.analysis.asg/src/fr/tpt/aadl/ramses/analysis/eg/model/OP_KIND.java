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

package fr.tpt.aadl.ramses.analysis.eg.model;

import org.apache.log4j.Logger ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;

import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public enum OP_KIND {
	ADD, SUB, MUL, DIV, MOD, AND, OR, NOT, MUTEX, JMP, LOAD, STORE, NONE, 
	EQUAL, NOT_EQUAL, LESS_THAN, LESS_OR_EQUAL_THAN, GREATER_THAN, GREATER_OR_EQUAL_THAN,
	NEGATIVE, POSITIVE;
	
	private static Logger _LOGGER = Logger.getLogger(OP_KIND.class) ;
	
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
		String msg = '\'' + e.name() + "\' is not yet supported";
		_LOGGER.error(msg) ;
		ServiceProvider.SYS_ERR_REP.error(msg, true) ;
		return NONE;
	}
};