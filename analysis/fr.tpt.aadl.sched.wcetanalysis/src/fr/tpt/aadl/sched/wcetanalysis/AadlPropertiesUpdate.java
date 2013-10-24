package fr.tpt.aadl.sched.wcetanalysis;

import java.util.List;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.util.SequenceUtil;
import org.osate.utils.PropertyUtils;

public class AadlPropertiesUpdate {

	private AadlPropertiesUpdate() {}
	
	private static final Property Access_Time_Property;
	
	static
	{
		PropertySet ps = Aadl2Factory.eINSTANCE.createPropertySet();
		ps.setName("Memory_Properties");
		
		Access_Time_Property = ps.createOwnedProperty();
		Access_Time_Property.setName("Access_Time");
	}
	
	public static void update(TaskBody source)
	{
		final ComponentInstance t = source.getTask();
		System.out.println("  Update thread " + t.getName());
		
		updateExecutionTime(source, t);
		updateAccessTimes(source, t);
	}

	private static void updateExecutionTime(TaskBody source, final ComponentInstance t) {
		final double bcet = source.getBCET();
		final double wcet = source.getWCET();

		final double wcet0 = getInitialWCET(t);

		updateExecutionTime(t, bcet, wcet);
		updateExecutionTime(t.getSubcomponent(), bcet, wcet);

		System.out.println("    WCET:\t\t\t" + wcet0 + " -> " + wcet);
	}

	private static double getInitialWCET(NamedElement e) {
		PropertyAssociation pa = PropertyUtils.getPropertyAssociation(e,
				"Compute_Execution_Time");
		if (pa != null) {
			ModalPropertyValue mpv = pa.getOwnedValues().get(0);
			PropertyExpression value = mpv.getOwnedValue();
			NumberValue nv = null;
			if (value instanceof RangeValue) {
				nv = ((RangeValue) value).getMaximumValue();
			} else if (value instanceof NumberValue) {
				nv = (NumberValue) value;
			}

			if (nv instanceof IntegerLiteral) {
				return (double) (((IntegerLiteral) nv).getValue());
			} else if (nv instanceof RealLiteral) {
				return (double) (((RealLiteral) nv).getValue());
			}
		}
		return -1d;
	}
	
	private static void updateAccessTimes(TaskBody source, final ComponentInstance t)
	{	
		ASTNode sequence = source.getReducedMainLoopAST();
		List<ASTNode> nodesGet = SequenceUtil.getAll(
				StatementKind.GetResource, sequence);
		List<ASTNode> nodesRel = SequenceUtil.getAll(
				StatementKind.ReleaseResource, sequence);
		
		if (nodesGet.size() != nodesRel.size())
		{
			throw new RuntimeException("Number of GetResource calls not equal to number of ReleaseResource calls");
		}
		
		for(int iRes=0;iRes<nodesGet.size();iRes++)
		{
			//Assume there is only one critical section per resource
			
			ASTNode nodeGet   = nodesGet.get(iRes);
			String resourceID = nodeGet.getResourceID();
			ASTNode nodeRel   = getRelease(nodesRel, resourceID);
			
			double startCS    = nodeGet.getMinStartTime();
			double endCS      = startCS + getMaxTimeBetween(nodeGet,nodeRel);
			
			System.out.println("    Access Time (" + resourceID + "):\tFirst="+startCS + "\tLast="+endCS);
			
			updateAccessTime(t, resourceID, startCS, endCS);
		}
	}
	
	private static ASTNode getRelease(List<ASTNode> nodes, String resourceID)
	{
		for(ASTNode n : nodes)
		{
			if (n.getType() == StatementKind.ReleaseResource
					&& n.getResourceID().equals(resourceID))
			{
				return n;
			}
		}
		return null;
	}
	
	private static double getMaxTimeBetween(ASTNode nodeGet, ASTNode nodeRel)
	{
		List<ASTNode> sub = SequenceUtil.getSubsequence(nodeGet,nodeRel);
		double time = 0d;
		for(ASTNode n : sub)
		{
			time += n.getMaxExecutionTime();
		}
		return time;
	}
	
	private static void updateExecutionTime(NamedElement e, double bcet, double wcet) {
		PropertyAssociation pa = PropertyUtils.getPropertyAssociation(e,
				"Compute_Execution_Time");
		if (pa != null) {
			ModalPropertyValue mpv = pa.getOwnedValues().get(0);
			PropertyExpression value = mpv.getOwnedValue();
			if (value instanceof RangeValue) {
				updateRange((RangeValue) value, bcet, wcet);
			} else if (value instanceof NumberValue) {
				UnitLiteral unit = ((NumberValue) value).getUnit();
				RangeValue rv = createRange(unit, bcet, wcet);

				mpv.setOwnedValue(rv);
			}
		}
	}

	private static void updateAccessTime(ComponentInstance t, String resourceID,
			double startCS, double endCS)
	{
		DataAccess da = getDataAccess(t,resourceID);
		PropertyAssociation pa = PropertyUtils.getPropertyAssociation(da, 
				"Access_Time");
		if (pa == null)
		{
			RecordValue rvStart = Aadl2Factory.eINSTANCE.createRecordValue();
			RecordValue rvEnd = Aadl2Factory.eINSTANCE.createRecordValue();
			
			addRecordValueField(rvStart, "Offset", startCS, "ms");
			addRecordValueField(rvEnd, "Offset", endCS, "ms");
			
			RecordValue rv = Aadl2Factory.eINSTANCE.createRecordValue();
			addRecordValueField(rv, "First", rvStart);
			addRecordValueField(rv, "Last", rvEnd);
			
			pa = da.createOwnedPropertyAssociation();
			pa.setProperty(Access_Time_Property);
			
			ModalPropertyValue mpv = pa.createOwnedValue();
			mpv.setOwnedValue(rv);
		}
	}
	
	
	
	private static void updateRange(RangeValue rv, double bcet, double wcet) 
	{
		UnitLiteral unitRef = rv.getMinimumValue().getUnit();
		
		double factor = unitRef.getFactor().getScaledValue();
		UnitLiteral unit = unitRef.getBaseUnit(); 
		
		if ((((int) bcet) == bcet) && (((int) wcet) == wcet))
		{
			factor = 1d;
			unit = unitRef;
		}
		
		
		IntegerLiteral min = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		IntegerLiteral max = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		
		int bcetInt = (int) (bcet * factor);
		int wcetInt = (int) (wcet * factor);

		min.setUnit(unit);
		min.setValue(bcetInt);
		max.setUnit(unit);
		max.setValue(wcetInt);

		rv.setMinimum(min);
		rv.setMaximum(max);
	}

	private static RangeValue createRange(UnitLiteral unitRef, double bcet,
			double wcet) 
	{
		double factor = unitRef.getFactor().getScaledValue();
		UnitLiteral unit = unitRef.getBaseUnit();
		if ((((int) bcet) == bcet) && (((int) wcet) == wcet))
		{
			factor = 1d;
			unit = unitRef;
		}
		
		
		int bcetInt = (int) (bcet * factor);
		int wcetInt = (int) (wcet * factor);
		
		RangeValue rv = Aadl2Factory.eINSTANCE.createRangeValue();
		IntegerLiteral min = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		IntegerLiteral max = Aadl2Factory.eINSTANCE.createIntegerLiteral();

		min.setUnit(unit);
		min.setValue(bcetInt);
		max.setUnit(unit);
		max.setValue(wcetInt);

		rv.setMinimum(min);
		rv.setMaximum(max);

		return rv;
	}

	private static DataAccess getDataAccess(ComponentInstance t, String resourceID)
	{
		//String resourceID = findAccessedDataName(t,accessID);
		ThreadImplementation ti = (ThreadImplementation) 
				t.getSubcomponent().getSubcomponentType();
		
		ThreadType tt = ti.getType();
		
		for(DataAccess da : tt.getOwnedDataAccesses())
		{
			if (da.getName().equals(resourceID))
			{
				return da;
			}
		}
		return null;
	}
	
	/*private static String findAccessedDataName(ComponentInstance t, String accessID)
	{
		ComponentInstance process = (ComponentInstance) t.eContainer();
		for(ConnectionInstance ci : process.getConnectionInstances())
		{
			if (ci.getKind()==ConnectionKind.ACCESS_CONNECTION)
			{
				ConnectionInstanceEnd src = ci.getSource();
				ConnectionInstanceEnd dst = ci.getDestination();
				
				if ((dst.eContainer()==t) && (dst.getName().equals(accessID)))
				{
					return src.getName();
				}
			}
		}
		return accessID;
	}*/
	
	private static void addRecordValueField(RecordValue rv, 
			String field, double val, String unitName)
	{
		UnitLiteral unit = Aadl2Factory.eINSTANCE.createUnitLiteral();
		unit.setName(unitName);
		
		RealLiteral value = Aadl2Factory.eINSTANCE.createRealLiteral();
		value.setValue(val);
		value.setUnit(unit);
		
		addRecordValueField(rv, field, value);
	}
	
	private static void addRecordValueField(RecordValue rv, 
			String field, PropertyExpression value)
	{
		BasicPropertyAssociation bpa = rv.createOwnedFieldValue();
		
		BasicProperty bp = Aadl2Factory.eINSTANCE.createBasicProperty();
		bp.setName(field);
		
		bpa.setProperty(bp);
		bpa.setOwnedValue(value);
	}
}