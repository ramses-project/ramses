package fr.tpt.aadl.ramses.generation.adaravenscar;


import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Property;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import fr.tpt.aadl.utils.PropertyUtils;

public class GenerationUtilsADA
{
	public final static String THREAD_SUFFIX = "_Job" ;
	  
	  // Give file name, in upper case or not and with or without extension.
	  public static String generateHeaderInclusionGuard(String fileName)
	  {
		fileName = fileName.replaceFirst(fileName.substring(0, 1), fileName.substring(0, 1).toUpperCase());
		StringBuilder result;
		
		if(fileName.endsWith(".ads")){ 
			fileName = fileName.replaceFirst(".ads", "");
			result = new StringBuilder ("package " + fileName + " is\n");
		}
		else{
			fileName = fileName.replaceFirst(".adb", "");
			result = new StringBuilder ("package body " + fileName + " is\n");
		}
	    return result.toString() ;
	  }
	  
	  public static String getGenerationADAIdentifier(String id)
	  {
	    return id.replaceAll("::", "__").replace('.', '_') ;
	  }

	  public static String generateSectionTitle(String object)
	  {
	    checkSectionObject(object) ;
	    int maxChar = 80 ;
	    char spacer = ' ' ;
	    StringBuilder sb = new StringBuilder() ;
	    int titleChar = maxChar - object.length() - 8 ;
	    int nbStars = titleChar / 2 ;
	    boolean symetric = (titleChar % 2) == 0 ;
	    sb.append("-- ") ;

	    for(int i = 0 ; i < nbStars ; i++)
	    {
	      sb.append(spacer) ;
	    }

	    sb.append(' ') ;
	    sb.append(object) ;
	    sb.append(' ') ;

	    if(false == symetric)
	    {
	      nbStars++ ;
	    }

	    for(int i = 0 ; i < nbStars ; i++)
	    {
	      sb.append(spacer) ;
	    }

	    sb.append("\n") ;
	    return sb.toString() ;
	  }

	  public static String generateSectionComment(String comment)
	  {
	    checkSectionObject(comment) ;
	    int maxChar = 80 ;
	    char spacer = ' ' ;
	    StringBuilder sb = new StringBuilder() ;
	    int titleChar = comment.length() + 4 ;
	    sb.append("-- ") ;
	    sb.append(comment) ;
	    sb.append(' ') ;

	    for(int i = titleChar ; i < maxChar - 3 ; i++)
	    {
	      sb.append(spacer) ;
	    }

	    //sb.append("") ;
	    return sb.toString() ;
	  }

	  private static void checkSectionObject(String object)
	  {
	    if(object.length() > 74) // 80 - 6 length of /*_ x 2
	    {
	      String errorMsg = "title more than 78 characters" ;
	      throw new UnsupportedOperationException(errorMsg) ;
	    }
	  }

	  public static String generateSectionMark()
	  {
	    return "" ;
	  }
	   
	  
	  public static boolean isReturnParameter(Parameter p)
	  {
		  boolean isReturnParam=false;
		  try {
			isReturnParam =
					  PropertyUtils.getBooleanValue(p, "Return_Parameter") ;
		  } catch (Exception e) {
		    Property prop = GetProperties.lookupPropertyDefinition(p, "Generation_Properties", "Return_Parameter") ;
			BooleanLiteral bl = (BooleanLiteral) prop.getDefaultValue() ;
			isReturnParam = bl.getValue();
		  }
		  return isReturnParam;
	  }
}
