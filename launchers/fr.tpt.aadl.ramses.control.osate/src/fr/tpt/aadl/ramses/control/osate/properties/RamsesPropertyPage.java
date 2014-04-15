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

package fr.tpt.aadl.ramses.control.osate.properties;

import java.io.File ;
import java.io.FileNotFoundException ;

import org.apache.log4j.Logger ;
import org.eclipse.core.resources.IContainer ;
import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IResource ;
import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.Path ;
import org.eclipse.core.runtime.QualifiedName ;
import org.eclipse.jface.preference.PreferenceDialog ;
import org.eclipse.jface.preference.PreferencePage ;
import org.eclipse.jface.window.Window ;
import org.eclipse.swt.SWT ;
import org.eclipse.swt.events.SelectionAdapter ;
import org.eclipse.swt.events.SelectionEvent ;
import org.eclipse.swt.layout.GridData ;
import org.eclipse.swt.layout.GridLayout ;
import org.eclipse.swt.widgets.Button ;
import org.eclipse.swt.widgets.Composite ;
import org.eclipse.swt.widgets.Control ;
import org.eclipse.swt.widgets.DirectoryDialog ;
import org.eclipse.swt.widgets.Event ;
import org.eclipse.swt.widgets.Label ;
import org.eclipse.swt.widgets.Listener ;
import org.eclipse.swt.widgets.Shell ;
import org.eclipse.swt.widgets.Text ;
import org.eclipse.ui.dialogs.ContainerSelectionDialog ;
import org.eclipse.ui.dialogs.PreferencesUtil ;
import org.eclipse.ui.dialogs.PropertyPage ;
import org.osate.utils.FileUtils ;

import fr.tpt.aadl.ramses.control.osate.WorkbenchUtils ;
import fr.tpt.aadl.ramses.control.support.config.ConfigStatus ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.generation.osek.OSEKGeneratorFactory ;
import fr.tpt.aadl.ramses.generation.pok.c.PokGeneratorFactory ;

public class RamsesPropertyPage extends PropertyPage {

  private static final String PATH_TITLE = "Output directory (where code will be generated)";

  private static final String _PROPERTY_PAGE_ID = "fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage" ;
  
  public static final String PREFIX = "fr.tpt.aadl.ramses.";
  public static final String OUTPUT_DIR = "output.directory";
  public static final String TARGET_ID = "target.id";
  public static final String RUNTIME_PATH = "runtime.path";
  public static final String PREF = "pref_pok";
  
  private static final String _OJR_PLATFORM = "ojr" ;

  private String DEFAULT_PATH;
  private String PROJECT_NAME;  

  protected static final int TEXT_FIELD_WIDTH = 43;

  protected Text outputDirText;
  private Button target;
  private Text runtimePathText;
  private Label selectedPathLabel;
  private RamsesConfiguration _config;
  protected IProject _project ;
  
  private static Logger _LOGGER = Logger.getLogger(RamsesPropertyPage.class) ;
  
  /**
   * Constructor for SamplePropertyPage.
   */
  public RamsesPropertyPage() {
    super();
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

  private void addInformationSection(Composite parent) {
    Composite composite = createDefaultComposite(parent);

    //Label for information
    Label pathLabel = new Label(composite, SWT.CENTER);
    pathLabel.setText("This property page enable you to configure RAMSES code generator");
  }

  protected void addSeparator(Composite parent) {
    Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
    GridData gridData = new GridData();
    gridData.horizontalAlignment = GridData.FILL;
    gridData.grabExcessHorizontalSpace = true;
    separator.setLayoutData(gridData);
  }

  public static String getDefaultOutputDir(IResource resource)
  {
    return resource.getLocation().makeAbsolute().toOSString();
  }
  
  protected void addOutputDirectorySection(Composite parent,
                                         RamsesConfiguration config,
                                         String labelMessage)
  {
    Label label = new Label(parent, SWT.BOLD);
    label.setText("1 - "+labelMessage);

    Composite composite = createDefaultComposite(parent);

    // Label for output directory field
    Label ownerLabel = new Label(composite, SWT.BOLD);
    ownerLabel.setText(PATH_TITLE);

    // output Directory button field
    outputDirText = new Text(composite, SWT.SINGLE | SWT.BORDER);
    GridData gd = new GridData();
    gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
    outputDirText.setLayoutData(gd);
    outputDirText.setEditable(false) ;

    // Populate output dir text field
    DEFAULT_PATH = getDefaultOutputDir((IResource) getElement());
    PROJECT_NAME = (((IResource) getElement()).getName()) ;

    if (config.getOutputDir() == null)
        outputDirText.setText(DEFAULT_PATH);
      else
        outputDirText.setText(config.getOutputDir().getAbsolutePath());
    
    // Move the cursor to the end.
    outputDirText.setSelection(outputDirText.getText().length()) ;

    Button button = new Button(composite, SWT.PUSH);
    button.setText("Browse existing directories in workspace...");
    button.setAlignment(SWT.LEFT);

    button.addSelectionListener( new SelectionAdapter() 
    {
      public void widgetSelected(SelectionEvent e) 
      {
        ContainerSelectionDialog browseWorkspace = 
            new ContainerSelectionDialog(getShell(),
                (IContainer) getElement(),
                true,
                "Select output directory for generated code"
                );
                    if (browseWorkspace.open() == ContainerSelectionDialog.OK) {
                      Object[] result = browseWorkspace.getResult();
                      if (result != null && result.length > 0) {
                        Path outputDir = (Path) result[0];
                        
                        outputDirText.setText(convertToAbsolutePath(outputDir));
                        // Move the cursor to the end.
                        outputDirText.setSelection(outputDirText.getText().length()) ;
                      }
                    }
      }
    });
  }

  private String convertToAbsolutePath(Path relativePath)
  {
    String root = File.separator + PROJECT_NAME ;

    if(root.equals(relativePath.toOSString()))
    {
      return DEFAULT_PATH ;
    }
    else
    {
      return DEFAULT_PATH + File.separator +
          relativePath.removeFirstSegments(1).toOSString() ;
    }
  }

  protected Composite createDefaultComposite(Composite parent) {
    Composite composite = new Composite(parent, SWT.NULL);
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    composite.setLayout(layout);

    GridData data = new GridData();
    data.verticalAlignment = GridData.FILL;
    data.horizontalAlignment = GridData.FILL;
    composite.setLayoutData(data);

    return composite;
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
    		"Select output directory for generated code");
    addSeparator(composite);
    addTargetSection(composite, _config);
    
    return composite;
  }

  private void addTargetSection(Composite composite, RamsesConfiguration config)
  {
    Label targetInfo = new Label(composite, SWT.BOLD);
    targetInfo.setText("2 - Select one of the following target platforms to generate code for:");
    // Create checkboxes for targets supported by RAMSES

    // TODO :  Should be deduced from the plugin.xml of generators;
    // see ramses (OSGI)
    Button arinc = new Button(composite, SWT.RADIO);
    arinc.setText("ARINC653 - POK (http://pok.tuxfamily.org/)");
    arinc.setData(PokGeneratorFactory.POK_GENERATOR_NAME);

    Button ojr = new Button(composite, SWT.RADIO);
    ojr.setText("Java - OJR");
    ojr.setData(_OJR_PLATFORM);

    Button osek = new Button(composite, SWT.RADIO);
    osek.setText("OSEX/NXT - nxtOSEK (http://lejos-osek.sourceforge.net/)");
    osek.setData(OSEKGeneratorFactory.OSEK_GENERATOR_NAME);
    
    if(config.getTargetId() != null)
    {
      if(config.getTargetId().
    		  equals(_OJR_PLATFORM ))
      {
        target = ojr ;
      }
      else if(config.getTargetId().
    		  equals(PokGeneratorFactory.POK_GENERATOR_NAME))
      {
    	target = arinc ;
      }
      else if(config.getTargetId().
    		  equals(OSEKGeneratorFactory.OSEK_GENERATOR_NAME))
      {
          target = osek ;
      }
      target.setSelection(true) ;
    }
    
    Listener listener = new Listener()
    {
      @Override
      public void handleEvent(Event event)
      {
        Button button = (Button)(event.widget);
        selectedPathLabel.setText("Select path for :"+button);
        selectedPathLabel.redraw();
        if (button.getSelection())
        {
          target = button;
        }
      }
    };

    osek.addListener(SWT.Selection, listener);
    arinc.addListener(SWT.Selection, listener);
    ojr.addListener(SWT.Selection, listener);

    Button pathButton = new Button(composite, SWT.PUSH);
    pathButton.setText("Choose the target platform path");
    pathButton.setAlignment(SWT.RIGHT);

    selectedPathLabel = new Label(composite, SWT.BOLD); 
    selectedPathLabel.setText("Path for target not selected ...");
    selectedPathLabel.setSize(TEXT_FIELD_WIDTH, 50);
    GridData grdPath = new GridData();
    grdPath.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
    selectedPathLabel.setLayoutData(grdPath) ;

    runtimePathText = new Text(composite, SWT.BOLD | SWT.SINGLE | SWT.BORDER);
    runtimePathText.setEditable(false) ;
    GridData grd = new GridData();
    grd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
    runtimePathText.setLayoutData(grd) ;
    
    if(config.getRuntimePath() != null)
    {
      runtimePathText.setText(config.getRuntimePath().getAbsolutePath());
    }

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
          runtimePathText.setText(selectedFile.getAbsolutePath());
        }
      }
    });
  }


  
  private void saveConfiguration() throws CoreException
  {
    _project.setPersistentProperty(new QualifiedName(PREFIX, OUTPUT_DIR),
                                  outputDirText.getText());
    
    _project.setPersistentProperty(new QualifiedName(PREFIX, TARGET_ID),
                                  target.getData().toString()) ;
    
    if(! _OJR_PLATFORM.equals(target.getData().toString()))
    {
      _project.setPersistentProperty(new QualifiedName(PREFIX, RUNTIME_PATH),
                                    runtimePathText.getText());
    }
  }

  /**
   * @see PreferencePage#performDefaults()
   */
  @Override
  protected void performDefaults() {
    super.performDefaults();
    outputDirText.setText(DEFAULT_PATH);
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

  private short configChecker()
  {
    short result = 0 ; // Zero means no error.

    if(outputDirText.getText() == null || outputDirText.getText().isEmpty())
    {
      result += 10 ;
    }

    if(target != null && target.getData() != null)
    {
      ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
      Generator gen = sr.getGenerator(target.getData().toString()) ;
      if(gen != null)
      {
        try
        {
          File runtimePath = null ;
          
          if(runtimePathText.getText() != null &&
             ! runtimePathText.getText().isEmpty())
          {
            runtimePath = FileUtils.stringToFile(runtimePathText.getText()) ;
          }
          // the runtime path can be null.
          if(! gen.runtimePathChecker(runtimePath))
          {
            result +=400 ;
          }
        }
        catch (FileNotFoundException e)
        {
          result +=300 ;
        }
      }
      else
      {
        result +=200 ;
      }
    }
    else
    {
      result += 100 ;
    }

    return result ;
  }
  
  private void popupConfigurationErrorMessage(short errno)
  {
    StringBuilder msg =
             new StringBuilder("Cannot save RAMSES configuration:\n\n");

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
          msg.append("\n\tTarget is missing.") ;
          break ;
        }
        
        case 2 :
        {
          msg.append("\n\tThe target " + target.getData().toString() + " is not supported.") ;
          break ;
        }
        
        case 3 :
        {
          msg.append("\n\tThe runtime is missing.") ;
          break ;
        }
        
        case 4 :
        {
          msg.append("\n\tThe given runtime is not a valid " + target.getData().toString() + " runtime.") ;
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
  
  public static String fetchPropertiesValue(IProject project,
                                             String property) throws
                                                           CoreException
  {
    String value = project.getPersistentProperty(new QualifiedName(
                                                   RamsesPropertyPage.PREFIX,
                                                   property));
    return value ;
  }
  
  public static void fetchProperties(IProject project, RamsesConfiguration result) throws
                                                                   CoreException,
                                                                   ConfigurationException
  {
    ConfigStatus status ;
    
    status = result.setRamsesOutputDir(fetchPropertiesValue(project, OUTPUT_DIR)) ;
    if(status != ConfigStatus.SET)
    {
      throw new ConfigurationException(status) ;
    }
    
    status = result.setGenerationTargetId(fetchPropertiesValue(project, TARGET_ID)) ;
    if(status != ConfigStatus.SET)
    {
      throw new ConfigurationException(status) ;
    }

    status = result.setRuntimePath(fetchPropertiesValue(project, RUNTIME_PATH)) ;
    if(status != ConfigStatus.SET)
    {
      throw new ConfigurationException(status) ;
    }
    
  }
  
  // Return false if user has canceled.
  public static boolean openPropertyDialog(IProject project)
  {
    Shell shell = WorkbenchUtils.getCurrentShell() ;
    
    //Instantiate the project propertyPage.
    PreferenceDialog prefDiag = PreferencesUtil.
        createPropertyDialogOn(shell, project, _PROPERTY_PAGE_ID, null,
                               null);
    
    // TODO: display the missing informations.
    
    return prefDiag.open() == Window.OK ;
  }
}