package fr.tpt.aadl.ramses.control.osate;

import java.io.File;

import fr.tpt.aadl.ramses.control.support.config.ConfigStatus;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;

public class AadlInspectorConfiguration extends RamsesConfiguration{

	private String _mode;
	private String _installDir;

	public ConfigStatus setInstallDir(String installDir) {
		ConfigStatus isValid = isValidInstallDir(installDir);
		if(isValid == ConfigStatus.SET)
		{
		  _installDir = installDir;
		  if(false==_installDir.endsWith("/"))
			  _installDir+="/";
		}
		return isValid;
	}
	
	public ConfigStatus isValidInstallDir(String installDir)
	{
		if(! (installDir == null || installDir.isEmpty()))
	    {
	      File outputDir = new File(installDir) ;
	      if(! outputDir.exists())
	      {
	    	  ConfigStatus.NOT_VALID.msg = "AADL inspector installation directory " +
	    	  		"is invalid (does not exist)" ;
	    	  return ConfigStatus.NOT_VALID ;
	      }
	      String bianryFilesDir = installDir;
	      if(false==bianryFilesDir.endsWith("/"))
	    	  bianryFilesDir+="/";
	      bianryFilesDir += "bin.common/";
	      
	      File testAIInstalled = new File(bianryFilesDir);
	      if(false==testAIInstalled.exists())
	      {
	    	  ConfigStatus.NOT_VALID.msg = "AADL inspector installation directory " +
		    	  		"is invalid (binary files not found)" ;
	    	  return ConfigStatus.NOT_VALID ;
	      }
	      return ConfigStatus.SET;
	    }
		else
	    {
	      ConfigStatus.NOT_VALID.msg = "AADL inspector install directory is not set" ;
	      return ConfigStatus.NOT_VALID ;
	    }
	}
	
	public String getInstallDir() {
		return _installDir;
	}

	public ConfigStatus setMode(String mode)
	{
		_mode = mode;
		return ConfigStatus.SET;
	}
	
	public String getMode() {
		return _mode;
	}

	
}
