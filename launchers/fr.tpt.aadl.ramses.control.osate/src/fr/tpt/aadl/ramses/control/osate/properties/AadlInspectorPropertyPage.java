package fr.tpt.aadl.ramses.control.osate.properties;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.osate.utils.FileUtils;

import fr.tpt.aadl.ramses.control.osate.WorkbenchUtils;
import fr.tpt.aadl.ramses.control.support.config.ConfigStatus;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider;

public class AadlInspectorPropertyPage extends RamsesPropertyPage {

	
	public static final String OUTPUT_DIR = "output.directory";
	public static final String MODE = "mode";
	public static final String AI_INSTALL_DIR = "ai.install.dir";
	private static final String DEFAULT_MODE = "automatic";
	
	private static String _PROPERTY_PAGE_ID = "fr.tpt.aadl.ramses.control.osate.properties.AadlInspectorPropertyPage";
	private RamsesConfiguration _config;
	private static Logger _LOGGER = Logger.getLogger(AadlInspectorPropertyPage.class) ;
  
	private Label installDirLabel;
	private Text InstallDirText;
	private Button[] modeButtons = new Button[2];
	private String selectedMode;
	
	public static void fetchProperties(IProject project,
			RamsesConfiguration result) throws CoreException, ConfigurationException {
		
		ConfigStatus status ;
	    
	    status = result.setAadlInspectorOutputDir(fetchPropertiesValue(project, OUTPUT_DIR)) ;
	    if(status != ConfigStatus.SET)
	    {
	      throw new ConfigurationException(status) ;
	    }
	    
	    status = result.setMode(fetchPropertiesValue(project, MODE)) ;
	    if(status != ConfigStatus.SET)
	    {
	      throw new ConfigurationException(status) ;
	    }
	    
	    status = result.setAadlInspectorInstallDir(fetchPropertiesValue(project, AI_INSTALL_DIR));
	    if(status != ConfigStatus.SET)
	    {
	      throw new ConfigurationException(status) ;
	    }
	    
	    
	}


	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL);
		data.grabExcessHorizontalSpace = true;
		composite.setLayoutData(data);

		loadConfig() ; 

		addInformationSection(composite);
		addSeparator(composite);
		addSeparator(composite);
		addOutputDirectorySection(composite, _config,
				"Select output directory to store analysis results");
		addSeparator(composite);
		addInstallDirSection(composite, _config);
		addSeparator(composite);
		addModeSection(composite);
		
		return composite;
	}

	
	private void addModeSection(Composite composite) {
		Label targetInfo = new Label(composite, SWT.BOLD);
		targetInfo.setText("3 - Select mode");
		
		String value = null;
		try {
			value = _project.getPersistentProperty(new QualifiedName(
			        RamsesPropertyPage.PREFIX,
			        MODE));
		} catch (CoreException e) {
			String msg = "cannot fetch RAMSES logging configuration" ;
			_LOGGER.fatal(msg, e) ;
			throw new RuntimeException(msg, e) ;
		}
		
		modeButtons[0] = new Button(composite, SWT.RADIO);
		modeButtons[0].setText("Graphical User Interface");
		modeButtons[0].setLocation(50,250);
		modeButtons[0].pack();
		
		modeButtons[1] = new Button(composite, SWT.RADIO);
		modeButtons[1].setText("Background");
		modeButtons[1].setLocation(50,250);
		modeButtons[1].pack();
		
		int i=-1;
		if(value == null || value.isEmpty())
		  value = DEFAULT_MODE;
		
		if(value.equalsIgnoreCase("manual"))
			i=0;
		else if(value.equalsIgnoreCase("automatic"))
			i=1;
		
		modeButtons[i].setSelection(true);
	}


	private void addInstallDirSection(Composite composite, RamsesConfiguration config)
	{
	  Label targetInfo = new Label(composite, SWT.BOLD);
	  targetInfo.setText("2 - Precise where AADL Inspector is installed");
	  
	  Button pathButton = new Button(composite, SWT.PUSH);
	  pathButton.setText("Choose AADL Inspector installation directory");
	  pathButton.setAlignment(SWT.RIGHT);
	  
	  installDirLabel = new Label(composite, SWT.BOLD); 
	  installDirLabel.setText("Path of install dir: ");
	  installDirLabel.setSize(TEXT_FIELD_WIDTH, 50);
	  GridData grdPath = new GridData();
	  grdPath.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
	  installDirLabel.setLayoutData(grdPath) ;
	  
	  InstallDirText = new Text(composite, SWT.BOLD | SWT.SINGLE | SWT.BORDER);
	  InstallDirText.setEditable(false) ;
	  if (config.getAadlInspectorInstallDir() != null)
		  InstallDirText.setText(config.getAadlInspectorInstallDir());
	  GridData grd = new GridData();
	  grd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
	  InstallDirText.setLayoutData(grd) ;
	  pathButton.addSelectionListener( new SelectionAdapter() 
	    {
	      public void widgetSelected(SelectionEvent e)
	      {       
	        DirectoryDialog ddg = new DirectoryDialog(getShell());
	        File selectedFile = null;
	        String file = ddg.open();
	        if(file != null && file.length() > 2)
	        {
	          selectedFile = new File(file);
	          InstallDirText.setText(selectedFile.getAbsolutePath());
	        }
	      }
	    });
	}
	
	private void popupConfigurationErrorMessage(short errno)
	  {
	    StringBuilder msg =
	             new StringBuilder("Cannot save AADL Inspector configuration:\n\n");

	    if(errno == 1)
	    {
	      msg.append("\n\tCan't fetch the project.") ;
	    }
	    else
	    {
	      int tmp = errno/100 ;
	      
	      switch(tmp)
	      {        
	        case 1 :
	        {
	        	msg.append("\n\tThe given install dir is not a valid.") ;
		        break ;
	        }
	        
	        case 2 :
	        {
	        	msg.append("\n\tThe install directory is missing.") ;
	        	break ;  
	        }
	      }
	      
	      if(errno%100 != 0)
	      {
	        msg.append("\n\tMissing output directory.") ;
	      }
	    }
	    
	    ServiceProvider.SYS_ERR_REP.error(msg.toString(), false);
	  }
	
	private short configChecker()
	  {
	    short result = 0 ; // Zero means no error.

	    if(outputDirText.getText() == null || outputDirText.getText().isEmpty())
	    {
	      result += 10 ;
	    }

	    try
	    {
	      File runtimePath = null ;     
	      if(InstallDirText.getText() != null &&
	             ! InstallDirText.getText().isEmpty())
	      {
	        runtimePath = FileUtils.stringToFile(InstallDirText.getText()) ;
	      }
	      // the runtime path can be null.
	      ConfigStatus status = _config.isValidInstallDir(runtimePath.getAbsolutePath());
	      if( status != ConfigStatus.SET)
	      {
	        result +=100 ;
	      }
	    }
	    catch (FileNotFoundException e)
	    {
	      result +=200 ;
	    }
	    
	    return result ;
	  }
	
	private void addInformationSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		//Label for information
		Label pathLabel = new Label(composite, SWT.CENTER);
		pathLabel.setText("This property page enable you to configure AADL Inspector");
	}
	
	private void loadConfig()
	{
		try
		{
			_project = (IProject) getElement() ;
			if(_config==null)
				_config =  new RamsesConfiguration() ;
			fetchProperties(_project, _config) ;
		}
		catch(ConfigurationException ee)
		{
			// Missing configuration or first time configuration.
			_config = new RamsesConfiguration() ;
		}
		catch(Exception e)
		{
			String msg = "cannot load RAMSES configuration" ;
			_LOGGER.fatal(msg, e) ;
			throw new RuntimeException(msg, e) ;
		}
	}
	
	// Return false if user has canceled.
	public static boolean openPropertyDialog(IProject project)
	{
	  Shell shell = WorkbenchUtils.getCurrentShell() ;
	    
	  //Instantiate the project propertyPage.
	  PreferenceDialog prefDiag = PreferencesUtil.
	  createPropertyDialogOn(shell, project, _PROPERTY_PAGE_ID , null,
	                               null);
	    
	  // TODO: display the missing informations.

	  return prefDiag.open() == Window.OK ;
	}
	
	
	/**
	 * @see PreferencePage#performOk()
	 */
	@Override
	public boolean performOk()
	{
		try
		{
			short errno = configChecker() ;

			if(errno == 0)
			{
				saveConfiguration();
				return true;
			}
			else
			{
				popupConfigurationErrorMessage(errno);
				return false;
			}
		}
		catch (CoreException e)
		{
			String msg = "cannot save RAMSES configuration" ;
			_LOGGER.fatal(msg, e) ;
			throw new RuntimeException(msg, e) ;
		}
	}
	
	private void saveConfiguration() throws CoreException
	{
		_project.setPersistentProperty(new QualifiedName(PREFIX, OUTPUT_DIR),
				outputDirText.getText());

		if(modeButtons[0].getSelection())
	    	selectedMode = "manual";
	    else if(modeButtons[1].getSelection())
	    	selectedMode = "automatic";
		
		_project.setPersistentProperty(new QualifiedName(PREFIX, MODE),
				selectedMode) ;

		_project.setPersistentProperty(new QualifiedName(PREFIX, AI_INSTALL_DIR),
				InstallDirText.getText()) ;
		
	}
}
