package fr.tpt.aadl.ramses.generator.pok.makefile ;

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

import fr.tpt.aadl.ramses.generator.pok.makefile.GenerateMakefile ;

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