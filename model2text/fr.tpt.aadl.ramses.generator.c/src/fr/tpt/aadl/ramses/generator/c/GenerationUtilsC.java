package fr.tpt.aadl.ramses.generator.c ;

public class GenerationUtilsC
{
  public final static String THREAD_SUFFIX = "_Job" ;
  
  // Give file name, in upper case or not and with or without extension.
  public static String generateHeaderInclusionGuard(String fileName)
  {
    fileName = fileName.toUpperCase() ;
    fileName = fileName.replace('.', '_') ;
    
    StringBuilder result = new StringBuilder("#ifndef __GENERATED_") ;
    result.append(fileName);
    result.append("__\n#define __GENERATED_") ;
    result.append(fileName) ;
    result.append("__\n") ;
    
    return result.toString() ;
  }
  
  public static String getGenerationCIdentifier(String id)
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
    sb.append("/* ") ;

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

    sb.append(" */\n") ;
    return sb.toString() ;
  }

  public static String generateSectionComment(String comment)
  {
    checkSectionObject(comment) ;
    int maxChar = 80 ;
    char spacer = ' ' ;
    StringBuilder sb = new StringBuilder() ;
    int titleChar = comment.length() + 4 ;
    sb.append("/* ") ;
    sb.append(comment) ;
    sb.append(' ') ;

    for(int i = titleChar ; i < maxChar - 3 ; i++)
    {
      sb.append(spacer) ;
    }

    sb.append(" */") ;
    return sb.toString() ;
  }

  private static void checkSectionObject(String object)
  {
    if(object.length() > 74) // 80 - 6 length of /*_ x 2
    {
      String errorMsg = "title more than 78 characters" ;
      System.err.println(errorMsg) ;
      throw new UnsupportedOperationException(errorMsg) ;
    }
  }

  public static String generateSectionMark()
  {
    return "\n/******************************************************************************/" ;
  }
}