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

package fr.tpt.aadl.ramses.generation.pok ;

import java.io.File;
import java.util.Map;

import fr.tpt.aadl.ramses.transformation.atl.AadlToTargetSpecificAadl;

public class AadlArinc653Transformation extends
                                       AadlToTargetSpecificAadl
{
    
  
  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }


	@Override
	public void initAtlFileNameList(File resourceFilePath)
	{
		ATL_FILE_NAMES = new String[]
        {"targets/arinc653/ExpandThreadsPorts.asm",
  			 "targets/shared/PortsCommonRefinementSteps.asm",
  			 "targets/shared/DispatchCommonRefinementSteps.asm",
  			 "targets/shared/BehaviorAnnexCommonRefinementSteps.asm",
	  	   "targets/arinc653/BlackboardCommunications.asm",
	  	   "targets/arinc653/BufferCommunications.asm",
	  	   "targets/arinc653/EventsCommunications.asm",
	  	   "targets/arinc653/QueuingCommunications.asm",
	  	   "targets/arinc653/SamplingCommunications.asm",
	  	   "targets/arinc653/ExpandThreadsDispatchProtocol.asm",
	  	   "ExpandSubprogramCalls.asm"};
		super.initAtlFileNameList(resourceFilePath);
	}
}
