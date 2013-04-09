package fr.tpt.aadl.ramses.generation.osek;

import java.io.File;
import java.util.Map;

import fr.tpt.aadl.ramses.transformation.atl.AadlToTargetSpecificAadl;

public class AadlOsekTransformation extends AadlToTargetSpecificAadl {

	public void initAtlFileNameList(File resourceFilePath)
	{
		ATL_FILE_NAMES = new String[] 
				{ 
			"targets/osek/ExpandThreadsPorts.asm", 
			"targets/osek/ExpandThreadsDispatchProtocol.asm",
			"targets/shared/PortsCommonRefinementSteps.asm",
			"targets/shared/DispatchCommonRefinementSteps.asm",
			"targets/shared/DispatchHWCommonRefinementSteps.asm",
			"targets/shared/BehaviorAnnexCommonRefinementSteps.asm",
			 "ExpandSubprogramCalls.asm", "CreateThreadsBehavior.asm" };
		super.initAtlFileNameList(resourceFilePath);
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		throw new UnsupportedOperationException();
	}

}
