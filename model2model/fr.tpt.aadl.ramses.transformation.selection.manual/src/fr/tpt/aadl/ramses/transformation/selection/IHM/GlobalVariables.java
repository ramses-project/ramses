package fr.tpt.aadl.ramses.transformation.selection.IHM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;

public class GlobalVariables implements Serializable {

	public static Map<List<EObject>, List<String>> toIHM = new HashMap<List<EObject>, List<String>>();
	public static Map<String,EObject> EobjectList_NameKey = new HashMap<String,EObject>();
	public static Map<EObject,String> EObjectList_EObjectKey = new HashMap<EObject,String>();
	public static TrcSpecification trc;	
	public static List<ChoosenRulesToApply> tuplesToApply = new ArrayList<ChoosenRulesToApply>();
	public static boolean doneSelecting = false ;
	public static final Object lock = new Object();
	public static boolean JFrameIsClosed = false ;
	public static ArrayList<ElementTransformation> applytuple = new ArrayList<ElementTransformation>();
	
	public static Map<List<EObject>, ArrayList<String>> testMap = new HashMap<List<EObject>, ArrayList<String>>();

}
