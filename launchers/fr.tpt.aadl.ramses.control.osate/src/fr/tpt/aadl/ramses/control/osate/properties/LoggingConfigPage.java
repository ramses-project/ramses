package fr.tpt.aadl.ramses.control.osate.properties;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.PropertyPage;

import fr.tpt.aadl.ramses.control.support.config.ConfigurationException;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;

public class LoggingConfigPage extends PropertyPage {

	private static final String DEFAULT_LOGGING_LEVEL = "WARNING";
	
	private IProject _project ;
	public static String LOGGING_LEVEL = "logging.level";
	
	private static Logger _LOGGER = Logger.getLogger(RamsesPropertyPage.class) ;
	
	private void addInformationSection(Composite parent) {
	    //Label for information
	    Label pathLabel = new Label(parent, SWT.CENTER);
	    pathLabel.setText("Select the quantity of verbosity you want in log files produced by RAMSES:\n" +
	    		"All (very verbose, every message is dumped) to Off (no trace at all)\n\n");
	  }
	
	private Button[] radioButtons = new Button[7];
	
	private void addLoggingSelectionButtons(Composite parent)
	{
		 
		_project = (IProject) getElement();
		String value = null;
		try {
			value = _project.getPersistentProperty(new QualifiedName(
			        RamsesPropertyPage.PREFIX,
			        LOGGING_LEVEL));
		} catch (CoreException e) {
			String msg = "cannot fetch RAMSES logging configuration" ;
			_LOGGER.fatal(msg, e) ;
			throw new RuntimeException(msg, e) ;
		}
		radioButtons[0] = new Button(parent, SWT.RADIO);
		radioButtons[0].setText("All");
		radioButtons[0].setLocation(50,250);
		radioButtons[0].pack();
	 
		radioButtons[1] = new Button(parent, SWT.RADIO);
		radioButtons[1].setText("Debug");
		radioButtons[1].setLocation(120,250);
		radioButtons[1].pack();
	 
		radioButtons[2] = new Button(parent, SWT.RADIO);
		radioButtons[2].setText("Info");
		radioButtons[2].setLocation(190,250);
		radioButtons[2].pack();
		
		radioButtons[3] = new Button(parent, SWT.RADIO);
		radioButtons[3].setText("Warning");
		radioButtons[3].setLocation(190,250);
		radioButtons[3].pack();

		radioButtons[4] = new Button(parent, SWT.RADIO);
		radioButtons[4].setText("Error");
		radioButtons[4].setLocation(190,250);
		radioButtons[4].pack();

		radioButtons[5] = new Button(parent, SWT.RADIO);
		radioButtons[5].setText("Fatal");
		radioButtons[5].setLocation(190,250);
		radioButtons[5].pack();

		radioButtons[6] = new Button(parent, SWT.RADIO);
		radioButtons[6].setText("Off");
		radioButtons[6].setLocation(190,250);
		radioButtons[6].pack();
		int i=-1;
		if(value == null || value.isEmpty())
		  value = DEFAULT_LOGGING_LEVEL;
		else
		{
		  if(value.equalsIgnoreCase("TRACE"))
			  i=0;
		  else if(value.equalsIgnoreCase("DEBUG"))
			  i=1;
		  else if(value.equalsIgnoreCase("INFO"))
			  i=2;
		  else if(value.equalsIgnoreCase("WARNING"))
			  i=3;
		  else if(value.equalsIgnoreCase("ERROR"))
			  i=4;
		  else if(value.equalsIgnoreCase("FATAL"))
			  i=5;
		  else if(value.equalsIgnoreCase("OFF"))
			  i=6;
		}
		radioButtons[i].setSelection(true);
	}
	
	@Override
	protected Control createContents(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    composite.setLayout(layout);
	    GridData data = new GridData(GridData.FILL);
	    data.grabExcessHorizontalSpace = true;
	    composite.setLayoutData(data);
		
	    addInformationSection(composite);
	    addLoggingSelectionButtons(composite);
		return composite;
		
	}

	
	/**
	   * @see PreferencePage#performDefaults()
	   */
	  @Override
	  protected void performDefaults() {
		radioButtons[3].setSelection(true);
	  }

	  /**
	   * @see PreferencePage#performOk()
	   */
	  @Override
	  public boolean performOk()
	  {
		try {
			setLoggingLevel();
		} catch (CoreException e) {
			String msg = "cannot save RAMSES logging configuration" ;
			_LOGGER.fatal(msg, e) ;
			throw new RuntimeException(msg, e) ;
		}
		return true;
	  }
	  /**
	   * @see PreferencePage#performApply()
	   */
	  @Override
	  public void performApply()
	  {
		  
		  try {
			setLoggingLevel();
		} catch (CoreException e) {
			String msg = "cannot save RAMSES logging configuration" ;
			_LOGGER.fatal(msg, e) ;
			throw new RuntimeException(msg, e) ;
		}
	  }
	  
	  void setLoggingLevel() throws CoreException
	  {
	    String lvl = null;
	    if(radioButtons[0].getSelection())
	      lvl = "TRACE";
	    else if(radioButtons[1].getSelection())
	      lvl = "DEBUG";
	    else if(radioButtons[2].getSelection())
		  lvl = "INFO";
	    else if(radioButtons[3].getSelection())
	      lvl = "WARNING";
	    else if(radioButtons[4].getSelection())
	      lvl = "ERROR";
	    else if(radioButtons[5].getSelection())
	      lvl = "FATAL";
	    else
	      lvl = "OFF";
	    
	    
	    _project.setPersistentProperty(new QualifiedName(RamsesPropertyPage.PREFIX,
	    		LOGGING_LEVEL),
	    		lvl);
	  }
	  
	  public static void fetchLoggingProperties(IProject project) throws
      CoreException,
      ConfigurationException
      {
		  String lvl = RamsesPropertyPage.fetchPropertiesValue(project,LOGGING_LEVEL);
		  if(lvl == null || lvl.isEmpty())
			  lvl = DEFAULT_LOGGING_LEVEL;
		  RamsesConfiguration.setupLogging(
				  lvl,
				  Platform.getLogFileLocation().toFile());
      }
}
