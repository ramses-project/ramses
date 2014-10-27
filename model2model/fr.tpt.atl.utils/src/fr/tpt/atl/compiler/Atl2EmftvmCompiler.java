package fr.tpt.atl.compiler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader ;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.compiler.EmftvmCompilerPlugin;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.engine.ProblemConverter;
import org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

public class Atl2EmftvmCompiler implements AtlStandaloneCompiler {

	protected final ResourceSet rs = new ResourceSetImpl();
	protected final Metamodel pbmm = EmftvmFactory.eINSTANCE.createMetamodel();
	protected final ExecEnvPool atlWfrPool = new ExecEnvPool();
	protected final ExecEnvPool atlToEmftvmPool = new ExecEnvPool();
	protected final ExecEnvPool inlineCodeblocksPool = new ExecEnvPool();
	
	public Atl2EmftvmCompiler() {
		super();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("ecore", new EcoreResourceFactoryImpl()) ;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("emftvm", new EMFTVMResourceFactoryImpl()) ;
		
		final Metamodel atlmm = EmftvmFactory.eINSTANCE.createMetamodel();
		atlmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getAtlMetamodel()).getResource());
		pbmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getProblemMetamodel()).getResource());
		final ModuleResolverFactory mrf = new DefaultModuleResolverFactory(URI.createPlatformPluginURI("fr.tpt.atl.utils/transformations/", false).toString());

		atlWfrPool.setModuleResolverFactory(mrf);
		atlWfrPool.registerMetaModel("ATL", atlmm);
		atlWfrPool.registerMetaModel("Problem", pbmm);
		atlWfrPool.loadModule("ATLWFR");

		atlToEmftvmPool.setModuleResolverFactory(mrf);
		atlToEmftvmPool.registerMetaModel("ATL", atlmm);
		atlToEmftvmPool.registerMetaModel("Problem", pbmm);
		atlToEmftvmPool.loadModule("ATLtoEMFTVM");

		inlineCodeblocksPool.setModuleResolverFactory(mrf);
		inlineCodeblocksPool.registerMetaModel("Problem", pbmm);
		inlineCodeblocksPool.loadModule("InlineCodeblocks");
	}
	
	public CompileTimeError[] compile(final InputStream in, final String outputFileName) {
		EObject[] eObjects = compileWithProblemModel(in, outputFileName);

		// convert the EObjects into an easily readable form (instances of CompileTimeError).
		CompileTimeError[] result = new CompileTimeError[eObjects.length];
		for (int i = 0; i < eObjects.length; i++) {
			result[i] = ProblemConverter.convertProblem(eObjects[i]);
		}

		// return them to caller
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public EObject[] compileWithProblemModel(final InputStream in, String outputFileName) {
		EObject[] result = new EObject[0];
		try {
			File asm = new File(outputFileName);
			if (asm.exists()) {
				asm.delete();
			}
			asm.createNewFile();
			// TODO Refactor ATL's compiler framework to support multiple file extensions
			if(false == outputFileName.endsWith(".emftvm"))
				outputFileName+=".emftvm";
			final OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName));
			try {
				result = compileWithProblemModel(in, outputStream);
			} finally {
				outputStream.close();
			}
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		}
		return result;
	}
	
	public EObject[] compileWithProblemModel(final InputStream in, final OutputStream outputStream) {
		final List<EObject> pbs = new ArrayList<EObject>();
		try {
			final IModel[] parsed = AtlParser.getDefault().parseToModelWithProblems(in, true);
			final IModel atlmodel = parsed[0];
			final IModel problems = parsed[1];

			if (getProblems(problems, pbs) == 0) {
				final EObject[] cpbs = compileWithProblemModel(atlmodel, outputStream);
				for (EObject cpb : cpbs) {
					pbs.add(cpb);
				}
			}
		} catch (ATLCoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		}
		return pbs.toArray(new EObject[pbs.size()]);
	}
	
	@SuppressWarnings("unchecked")
	protected int getProblems(IModel problems, Collection<EObject> pbElements) {
		final Collection<EObject> pbs = (Collection<EObject>) problems.getElementsByType(problems.getReferenceModel().getMetaElementByName(
				"Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			for (EObject pb : pbs) {
				EStructuralFeature severityFeature = pb.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
				if (severityFeature != null && "error".equals(((EEnumLiteral) pb.eGet(severityFeature)).getName())) { //$NON-NLS-1$
					nbErrors++;
				}
			}
			pbElements.addAll(pbs);
		}

		return nbErrors;
	}

	@Override
	public EObject[] compileWithProblemModel(IModel atlModel,
			OutputStream outputStream) {
		final List<EObject> pbs = new ArrayList<EObject>();

		final Model atlm = EmftvmFactory.eINSTANCE.createModel();
		atlm.setResource(((EMFModel) atlModel).getResource());

		final Resource pr = rs.createResource(URI.createFileURI("problems.xmi"));
		final Model pbm = EmftvmFactory.eINSTANCE.createModel();
		pbm.setResource(pr);

		final Resource r = rs.createResource(URI.createFileURI("out.emftvm"), "org.eclipse.m2m.atl.emftvm");
		final Model emftvmm = EmftvmFactory.eINSTANCE.createModel();
		emftvmm.setResource(r);

		final Resource ri = rs.createResource(URI.createFileURI("inlined.emftvm"), "org.eclipse.m2m.atl.emftvm");
		final Model emftvmmi = EmftvmFactory.eINSTANCE.createModel();
		emftvmmi.setResource(ri);

		final ExecEnv atlWfrEnv = atlWfrPool.getExecEnv();
		final ExecEnv atlToEmftvmEnv = atlToEmftvmPool.getExecEnv();
		final ExecEnv inlineCodeblocksEnv = inlineCodeblocksPool.getExecEnv();
		try {
			atlWfrEnv.registerInputModel("IN", atlm);
			atlWfrEnv.registerOutputModel("OUT", pbm);
			atlWfrEnv.run(null);

			if (getProblems(pbm, pbs) == 0) {
				atlToEmftvmEnv.registerInputModel("IN", atlm);
				atlToEmftvmEnv.registerOutputModel("OUT", emftvmm);
				atlToEmftvmEnv.registerOutputModel("PBS", pbm);
				atlToEmftvmEnv.run(null);

				if (getProblems(pbm, pbs) == 0) {
					inlineCodeblocksEnv.registerInputModel("IN", emftvmm);
					inlineCodeblocksEnv.registerOutputModel("OUT", emftvmmi);
					inlineCodeblocksEnv.run(null);

					ri.save(outputStream, Collections.emptyMap());
				}
			}
		} catch (VMException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		} finally {
			atlWfrPool.returnExecEnv(atlWfrEnv);
			atlToEmftvmPool.returnExecEnv(atlToEmftvmEnv);
			inlineCodeblocksPool.returnExecEnv(inlineCodeblocksEnv);
			rs.getResources().remove(pr); // unload
			rs.getResources().remove(r); // unload
			rs.getResources().remove(ri); // unload
		}

		return pbs.toArray(new EObject[pbs.size()]);
	}

	@Override
	public EObject[] compileWithProblemModel(IModel atlModel,
			String outputFileName) {
		// TODO Auto-generated method stub
		return null;
	}

	public CompileTimeError[] compile(String inputAtlFile, String outputFileName) {
		try {
			final InputStream inputStream = new BufferedInputStream(new FileInputStream(inputAtlFile));
			return this.compile(inputStream, outputFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Retrieves problem elements from <code>problems</code>.
	 * 
	 * @param problems
	 *            the problems model
	 * @param pbElements
	 *            the collection of problem elements to augment
	 * @return the number of error problems
	 */
	protected int getProblems(Model problems, Collection<EObject> pbElements) {
		final Collection<EObject> pbs = (Collection<EObject>) problems.allInstancesOf((EClass) pbmm.findType("Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			for (EObject pb : pbs) {
				EStructuralFeature severityFeature = pb.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
				if (severityFeature != null && "error".equals(((EEnumLiteral) pb.eGet(severityFeature)).getName())) { //$NON-NLS-1$
					nbErrors++;
				}
			}
			pbElements.addAll(pbs);
		}

		return nbErrors;
	}

  @Override
  public CompileTimeError[] compile(Reader arg0, String arg1)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EObject[] compileWithProblemModel(Reader arg0, String arg1)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EObject[] compileWithProblemModel(Reader arg0, OutputStream arg1)
  {
    // TODO Auto-generated method stub
    return null ;
  }
}
