package fr.tpt.aadl.ramses.generation.ada;

import java.util.List;
import java.util.Set;

import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
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
		  StringBuilder result;
		  if (fileName.equalsIgnoreCase("main.h") || fileName.equalsIgnoreCase("routing.h") || fileName.equalsIgnoreCase("deployment.h"))
		  {
			  fileName = fileName.toUpperCase();
			  fileName = fileName.replaceFirst(".H", "_H_");
			  result = new StringBuilder ("#ifndef __GENERATED_" + fileName + "\n#define __GENERATED_" + fileName + "\n\n");
		  }
		  else if(fileName.endsWith(".ads"))
		  { 
  			    fileName = fileName.replaceFirst(fileName.substring(0, 1), fileName.substring(0, 1).toUpperCase());
			    fileName = fileName.replaceFirst(".ads", "");
				result = new StringBuilder ("package " + fileName + " is\n");
		  }
		  else if(fileName.endsWith(".gpr"))
		  { 
  			    fileName = fileName.replaceFirst(fileName.substring(0, 1), fileName.substring(0, 1).toUpperCase());
			    fileName = fileName.replaceFirst(".gpr", "");
				result = new StringBuilder ("package " + fileName + " is\n");
		  } 
		  else 	  
		  {
			    fileName = fileName.replaceFirst(fileName.substring(0, 1), fileName.substring(0, 1).toUpperCase());
  			    fileName = fileName.replaceFirst(".adb", "");
	     		result = new StringBuilder ("package body " + fileName + " is\n");
		  }
		
	    return result.toString() ;
	  }
	  
	  public static String getGenerationADAIdentifier(String id)
	  {
	    return id.replaceAll("::", "_").replace('.', '_') ;
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

	  public static String generateSectionTitleC(String object)
	  {
	    checkSectionObject(object) ;
	    int maxChar = 80 ;
	    char spacer = ' ' ;
	    StringBuilder sb = new StringBuilder() ;
	    int titleChar = maxChar - object.length() - 8 ;
	    int nbStars = titleChar / 2 ;
	    boolean symetric = (titleChar % 2) == 0 ;
	    sb.append("// ") ;

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
	  public static String generateSectionTitleAda(String object)
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


	  public static String generateSectionMarkC()
	  {
	    return "\n//******************************************************************************" ;
	  }

	  public static String generateSectionMarkAda()
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
	  
	  
	  public static String resolveExistingCodeDependencies(NamedElement object,
				 Set<String> additionalHeaders)
	  {
		  try
		  {
			  NamedElement ne = object ;
			  List<String> sourceText =
					  PropertyUtils.getStringListValue(ne, "Source_Text") ;
			  for(String s : sourceText)
			  {
				  if(s.endsWith(".ads"))
				  {
					  additionalHeaders.add(s) ;
				  }
			  }

			String sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;
			return sourceName;
		  	}
		  catch(Exception e)
		  {
			  if(object instanceof ComponentType)
			  {
				  ComponentType c = (ComponentType) object;
				  if(c.getOwnedExtension()!=null)
					  return resolveExistingCodeDependencies(c.getOwnedExtension().getExtended(), additionalHeaders);
			  }
			  /*else   FIXME: ComponentPrototype */
			  else if (object instanceof ComponentImplementation)
			  {
				  ComponentImplementation ci = (ComponentImplementation) object;
				  if(ci.getOwnedExtension()!=null)
					  return resolveExistingCodeDependencies(ci.getOwnedExtension().getExtended(), additionalHeaders);
			  }
			  return null ;
		  }
}
}
