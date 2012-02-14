/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.generation.c ;

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