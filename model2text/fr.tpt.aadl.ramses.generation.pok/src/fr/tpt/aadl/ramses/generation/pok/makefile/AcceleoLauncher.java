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

package fr.tpt.aadl.ramses.generation.pok.makefile ;

/*
 * @author Etienne Borde
 */

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.common.util.BasicMonitor ;
import org.eclipse.emf.common.util.URI ;

/*
import com.martiansoftware.jsap.FlaggedOption ;
import com.martiansoftware.jsap.JSAP ;
import com.martiansoftware.jsap.JSAPException ;
import com.martiansoftware.jsap.JSAPResult ;
import com.martiansoftware.jsap.Switch ;
*/

import fr.tpt.aadl.ramses.generation.pok.makefile.GenerateMakefile ;

/**
 * Entry point of the 'GenerateMakefile' generation module.
 *
 * @generated
 */
@SuppressWarnings("all")
public class AcceleoLauncher
{

  public static void main(String[] args)
  {
    /*
    
    try
    {
     
      
      // model / Acceleo template names / Acceleo module file / output folder
      JSAP jsap = new JSAP() ;
      FlaggedOption model =
            new FlaggedOption("input_model")
                  .setStringParser(JSAP.STRING_PARSER).setRequired(true)
                  .setShortFlag('m').setAllowMultipleDeclarations(false)
                  .setLongFlag(JSAP.NO_LONGFLAG) ;
      Switch makefile =
            new Switch("makefile").setShortFlag(JSAP.NO_SHORTFLAG)
                  .setLongFlag("makefile") ;
      FlaggedOption outputFolder =
            new FlaggedOption("output_folder")
                  .setStringParser(JSAP.STRING_PARSER).setRequired(true)
                  .setShortFlag('o').setList(false)
                  .setLongFlag(JSAP.NO_LONGFLAG) ;
      jsap.registerParameter(model) ;
      jsap.registerParameter(makefile) ;
      jsap.registerParameter(outputFolder) ;
      JSAPResult config = jsap.parse(args) ;
      URI modelURI = URI.createFileURI(config.getString("input_model")) ;
      File folder = new File(config.getString("output_folder")) ;
      List<String> arguments = new ArrayList<String>() ;

      if(config.getBoolean("makefile"))
      {
        GenerateMakefile makefileGenerator =
              new GenerateMakefile(modelURI, folder, arguments) ;
        makefileGenerator.doGenerate(new BasicMonitor()) ;
      }
      
      
    }
    catch(JSAPException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
    
    */
  }
}