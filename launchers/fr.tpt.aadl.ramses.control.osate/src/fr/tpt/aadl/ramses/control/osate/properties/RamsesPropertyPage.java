package fr.tpt.aadl.ramses.control.osate.properties;

import java.io.File ;
import java.io.IOException;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Properties;

import org.eclipse.core.resources.IContainer ;
import org.eclipse.core.resources.IFile ;
import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IResource ;
import org.eclipse.core.resources.IWorkspaceRoot ;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.Path ;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.jface.dialogs.MessageDialog ;
import org.eclipse.jface.preference.PreferencePage ;
import org.eclipse.swt.SWT ;
import org.eclipse.swt.events.SelectionAdapter ;
import org.eclipse.swt.events.SelectionEvent ;
import org.eclipse.swt.graphics.FontMetrics ;
import org.eclipse.swt.graphics.GC ;
import org.eclipse.swt.layout.GridData ;
import org.eclipse.swt.layout.GridLayout ;
import org.eclipse.swt.widgets.Button ;
import org.eclipse.swt.widgets.Composite ;
import org.eclipse.swt.widgets.Control ;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event ;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label ;
import org.eclipse.swt.widgets.Listener ;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text ;
import org.eclipse.ui.IEditorPart ;
import org.eclipse.ui.IFileEditorInput ;
import org.eclipse.ui.IWorkbench ;
import org.eclipse.ui.IWorkbenchPage ;
import org.eclipse.ui.IWorkbenchWindow ;
import org.eclipse.ui.PlatformUI ;
import org.eclipse.ui.dialogs.ContainerSelectionDialog ;
import org.eclipse.ui.dialogs.PreferencesUtil ;
import org.eclipse.ui.dialogs.PropertyPage ;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil ;
import org.osate.ui.dialogs.Dialog;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;

public class RamsesPropertyPage extends PropertyPage {

	private static final String PATH_TITLE = "Output directory (where code will be generated)";

	public static final String PREFIX = "fr.tpt.aadl.ramses.";
	public static final String PATH_ID = "output.directory";
	public static final String TARGET_ID = "target";
	public static final String PLATFORM_ID = "platform";
	public static final String PREF = "pref_pok";

	private String DEFAULT_PATH;
	private String PROJECT_NAME;	

	private static final int TEXT_FIELD_WIDTH = 43;

	private IResource instanceModel = null;
	private Text outputDirText;
	private Button target;
	private Text outputPathText;
	private Text selectedInstanceName;
	private Label selectedPathLabel;
	private Label selectedInstanceModel;
	private QualifiedName qfName;
	
	/**
	 * Constructor for SamplePropertyPage.
	 */
	public RamsesPropertyPage() {
		super();
	}

	private void addInformationSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		//Label for information
		Label pathLabel = new Label(composite, SWT.CENTER);
		pathLabel.setText("This property page enable you to configure RAMSES code generator");
	}

	private void addSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(gridData);
	}

	private void addResourceSelectionSection(final Composite composite)
	{
//		Label label = new Label(composite, SWT.BOLD);
//		label.setText("1 - Select instance model to generate code from");
//		Button button = new Button(composite, SWT.PUSH);
//		button.setText("Select instance model...");
//		button.setAlignment(SWT.LEFT);
//		selectedInstanceModel = new Label(composite, SWT.BOLD);
//		selectedInstanceName = new Text(composite, SWT.BOLD | SWT.SINGLE | SWT.BORDER);
//		selectedInstanceName.setEditable(false);
//		GridData gd = new GridData();
//		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
//		selectedInstanceName.setLayoutData(gd) ;
//
//		if(instanceModel==null)
//		{
//			selectedInstanceModel.setText("No instance model selected");
//		}
//		button.addSelectionListener( new SelectionAdapter() 
//		{
//			public void widgetSelected(SelectionEvent e) 
//			{
//				IProject project = (IProject) getElement();
//				List<IResource> instanceModels = new ArrayList<IResource>();
//				populateInstanceModelList(project, instanceModels);
//				if(instanceModels.size()==0)
//				{
//					MessageDialog.openError(getShell(),
//							"Configuration Error",
//							"No instance model found in current projet. Instantiate your AADL model first.");
//					return;
//				}
//				IResource[] resourceArray = new IResource[instanceModels.size()]; 
//				instanceModels.toArray(resourceArray);
//				ResourceListSelectionDialog dialog = 
//						new ResourceListSelectionDialog(getShell(), 
//								resourceArray);
//				dialog.setTitle("Select instance model to generate code from");
//				dialog.setMessage("To display all available instance models, use *.aaxl2 as the search key.");
//				if (dialog.open() == ContainerSelectionDialog.OK) {
//					Object[] result = dialog.getResult();
//					if (result != null && result.length > 0) {
//						instanceModel = (IResource) result[0];
//						selectedInstanceModel.setText("Selected Instance model: ");
//						selectedInstanceModel.redraw();
//						selectedInstanceName.setText(instanceModel.getName());
//						int columns = instanceModel.getName().length();
//						GC gc = new GC(selectedInstanceModel);
//						FontMetrics fm = gc.getFontMetrics();
//						int width = columns * fm.getAverageCharWidth();
//						int height = fm.getHeight();
//						gc.dispose();
//						selectedInstanceName.setSize(selectedInstanceModel.computeSize(width, height));
//						selectedInstanceName.redraw();
//					}
//				}
//			}
//		});
	}

	private void populateInstanceModelList(IContainer container, List<IResource> instanceModelList)
	{
//		IResource[] projectResources ;
//		try
//		{
//			projectResources = container.members() ;
//
//			for (int i=0; i<container.members().length; i++)
//			{
//				if(projectResources[i] instanceof IContainer && !projectResources[i].getName().equalsIgnoreCase(".svn"))
//					populateInstanceModelList((IContainer) container.members()[i], instanceModelList);
//				else if(projectResources[i].getFileExtension()!=null &&
//						projectResources[i].getFileExtension().equals("aaxl2"))
//				{
//					// Get the resource
//					Resource resource=OsateResourceUtil.getResource(projectResources[i]);
//					// Get the first model element and cast it to the right type, in my
//					// example everything is hierarchical included in this first node
//					if(resource!= null && resource.getContents().get(0) instanceof SystemInstance)
//						instanceModelList.add(projectResources[i]);
//				}
//			}
//		}
//		catch(CoreException exc)
//		{
//			// TODO Auto-generated catch block
//			exc.printStackTrace();
//		}
	}

	private void addOutputDirectorySection(Composite parent) {

	  
		Label label = new Label(parent, SWT.BOLD);
		label.setText("2 - Select output directory to generate code in");

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
		DEFAULT_PATH = ((IResource) getElement()).getLocation().makeAbsolute().toOSString();
		PROJECT_NAME = (((IResource) getElement()).getName()) ;

		IResource resource = instanceModel;
		if(instanceModel!=null)
		{
			try {
				String value =
						resource.getPersistentProperty(new QualifiedName(PREFIX, PATH_ID));
				if (value == null)
					outputDirText.setText(DEFAULT_PATH);
				else
					outputDirText.setText(value);
			}
			catch (CoreException e) {
				e.printStackTrace();
			}
		} else
		{
			outputDirText.setText(DEFAULT_PATH);
			RamsesConfiguration.setOutputDir(new Path(DEFAULT_PATH).toFile());
		}
    RamsesConfiguration.setCurrentProject(ResourcesPlugin.getWorkspace().getRoot().getProject(PROJECT_NAME));
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

	private Composite createDefaultComposite(Composite parent) {
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
		
		addInformationSection(composite);
		addSeparator(composite);
		addResourceSelectionSection(composite);
		addSeparator(composite);
		addOutputDirectorySection(composite);
		addSeparator(composite);
		addTargetSection(composite);
		
		return composite;
	}

	private void addTargetSection(Composite composite)
	{
		Label targetInfo = new Label(composite, SWT.BOLD);
		targetInfo.setText("3 - Select one of the following target platforms to generate code for:");
		// Create checkboxes for targets supported by RAMSES

		// TODO :  Should be deduced from the plugin.xml of generators;
		// see ramses (OSGI)
		Button arinc = new Button(composite, SWT.RADIO);
		arinc.setText("ARINC653 - POK");
		arinc.setData("pok");

		Button ojr = new Button(composite, SWT.RADIO);
		ojr.setText("Java - OJR");
		ojr.setData("ojr");

		Button osek = new Button(composite, SWT.RADIO);
		osek.setText("OSEX/NXT - TRAMPOLINE");
		osek.setData("osek");

		Listener listener = new Listener()
		{

			@Override
			public void handleEvent(Event event)
			{
				Button button = (Button)(event.widget);

				System.out.println("Button =" + button);
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

		// Code added by achille
		Button pathButton = new Button(composite, SWT.PUSH);
		pathButton.setText("Choose the target platform path");
		pathButton.setAlignment(SWT.RIGHT);

		selectedPathLabel = new Label(composite, SWT.BOLD); 
		selectedPathLabel.setText("Path for target not selected ...");
		selectedPathLabel.setSize(TEXT_FIELD_WIDTH, 50);
		GridData grdPath = new GridData();
		grdPath.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		selectedPathLabel.setLayoutData(grdPath) ;

		outputPathText = new Text(composite, SWT.BOLD | SWT.SINGLE | SWT.BORDER);
		outputPathText.setEditable(false) ;
		GridData grd = new GridData();
		grd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		outputPathText.setLayoutData(grd) ;

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
					outputPathText.setText(selectedFile.getAbsolutePath());
				}
			}
		});
	}

	private boolean saveConfiguration() throws CoreException
	{
		boolean isCorrectConfiguration=true;
		IProject project = null;
//		if(instanceModel==null)
//			isCorrectConfiguration=false;
		if(isCorrectConfiguration && outputDirText.getText()!=null && !outputDirText.getText().equals("")
				&& outputPathText.getText()!=null && !outputPathText.getText().equals(""))
		{
		  if((project = RamsesConfiguration.getCurrentProject()) == null)
		   return false;
		  
		  project.setPersistentProperty(new QualifiedName(PREFIX, PATH_ID),
		                                outputDirText.getText());

		  project.setPersistentProperty(new QualifiedName(PREFIX, PLATFORM_ID),
		                                outputPathText.getText());
		      
		}

		else
			isCorrectConfiguration=false;
		if(isCorrectConfiguration && target != null && target.getData()!=null)
			project.setPersistentProperty(
					new QualifiedName(PREFIX, TARGET_ID),
					target.getData().toString());
		else
			isCorrectConfiguration=false;

		return isCorrectConfiguration;
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
	public boolean performOk() {
		// store the value in the owner text field
		try {
			if(saveConfiguration())
			  return true;
			else
			{
				popupConfigurationError();
				return false;
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void performApply() {
		// store the value in the owner text field
		try {
			if(!saveConfiguration())
			{
				System.out.println("Erreur Apply");
				popupConfigurationError();
			}
			else
			{				
				if(!RamsesConfiguration.pokRuntimePathValidityCheck(outputPathText.getText()))
				{
					Dialog.showError("Code Generation Error",
							"This path is not valid for "+target.getText());
					return;
				}
				RamsesConfiguration.setRuntimeDir(outputPathText.getText());
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	private void popupConfigurationError()
	{
		MessageDialog.openError(getShell(),
				"Configuration Error",
				"To configure RAMSES, you must select\n" +
						"\t 1 - an output directory, \n" +
						"\t 2 - and a target platform.\n" +
						"\t 3 - and a Path for the selected platform.\n\n" +
				"One of these elements was not configured properly.");
	}

}