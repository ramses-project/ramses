package fr.tpt.atl.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;

public class Atl2AsmCompiler {

	private static Atl2006Compiler compiler;

	public static void compile(String fileName){
		compiler = new Atl2006Compiler();	
		File file = new File(fileName);
		File fileASM = new File(file.getPath().replace(".atl", ".asm"));
		try {
			fileASM.createNewFile();
			CompileTimeError[] array = compiler.compile(new FileInputStream(file),fileASM.getAbsolutePath());
			
			if (array.length>0){
				for (int i=0; i<array.length; i++){
					System.err.println("CompileTimeError: "+array[i].getDescription()+" "+fileASM.getAbsolutePath()+" "+array[i].getLocation());					
				}
			}
			
		} catch (FileNotFoundException e) {
            System.out.println("Exception while calling the ATL compiler task: "+ e.getMessage());
            e.printStackTrace();
		} catch (IOException e) {
            System.out.println("ASM file generation failed with message: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
}
