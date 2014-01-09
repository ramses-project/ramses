package fr.tpt.aadl.ramses.util.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.util.OsateDebug;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;

public class FileUtils {

	public static Set<File> getIncludeDir(NamedElement object)
	{
		OsateDebug.osateDebug("[FileUtils] getIncludeDir for " + object);
		Set<File> includesConcat = new LinkedHashSet<File>();
		NamedElement namedElement = HookAccessImpl.getTransformationTrace(object);
		if ((namedElement!=null) && (namedElement != object))
		{
			OsateDebug.osateDebug("[FileUtils] namedElement not null " + namedElement);

			Set<File> includeDirSet = RamsesConfiguration.getIncludeDir(namedElement.getContainingClassifier().eResource());
			if(!includeDirSet.isEmpty())
			{
				includesConcat.addAll(includeDirSet);
			}
			includeDirSet.addAll(getIncludeDir(namedElement.getContainingClassifier()));
		}
		return includesConcat;
	}
}