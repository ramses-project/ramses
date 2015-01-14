package fr.tpt.aadl.ramses.generation.arinc653.xml.factory;

import org.osate.aadl2.NamedElement;
import org.osate.utils.PropertyUtils;

import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.control.workflow.List;


public abstract class ModelFactory<T> {
	
	public abstract T createFromAadl(NamedElement element, TargetProperties tarProp);
	@SuppressWarnings({ "unchecked", "hiding" })
	protected <T> T getPropVal(NamedElement i,String name,Class<T> c, boolean required) throws Exception
	{
		if(c.equals(String.class))
		{
			try {
				return (T) PropertyUtils.getStringValue(i, name);
			} catch (Exception e) {
				if(required)
					throw e;
				return null;
			}
		}
		if(c.equals(int.class) || c.equals(Integer.class))
		{
			try {
				return (T) Integer.valueOf(""+PropertyUtils.getIntValue(i, name));
			} catch (Exception e) {
				if(required)
					throw e;
				return null;
			}
		}
		if(c.isEnum())
		{
			try {
				return (T) PropertyUtils.getEnumValue(i, name).toString();
			} catch (Exception e) {
				if(required)
					throw e;
				return null;
			}
		}
		if(c.equals(boolean.class))
		{
			try {
				return (T) new Boolean(PropertyUtils.getBooleanValue(i, name));
			} catch (Exception e) {
				if(required)
					throw e;
				return null;
			}
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	protected <T> T getPropValDefault(NamedElement e, String name, Class<T> class1, Object def) {
		try {
			Object res=getPropVal(e, name, class1, false);
			return (T) (res==null?def:res);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return (T) def;
	}
}
