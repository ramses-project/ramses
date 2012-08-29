package fr.tpt.aadl.ramses.instantiation;

import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.xtext.aadl2.naming.Aadl2QualifiedNameProvider;

public class Aadl2StandAloneQualifiedNameProvider extends Aadl2QualifiedNameProvider 
{
	
	protected AnnexLinkingServiceRegistry getAnnexLinkingServiceRegistry(){
		
		return null;
	}
}
