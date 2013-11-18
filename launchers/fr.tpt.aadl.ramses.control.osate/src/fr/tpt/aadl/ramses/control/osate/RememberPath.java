package fr.tpt.aadl.ramses.control.osate;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RememberPath extends Dialog 
{
	private final static int TEXT_FIELD_WIDTH = 250; 
	private final String msgButton="";
	private final String platformType="POK";
	private Button browseButton;
	private Button applyButton;
	private Button cancelButton;
	private Text textPath;
	private Composite my_parent;
	private Composite container;
	
	public RememberPath(Shell parent) {
		super(parent);
		my_parent = parent;
		System.out.println("Remember path created");
		// TODO Auto-generated constructor stub
	}
	
	protected Control createContents(Composite parent)
	{
		
		CreateDialogArea(parent);
		createButtonBar(parent);
		return parent;
	}
	protected Control CreateDialogArea(Composite parent)
	{
		System.out.println("CreateDialogArea ...");
		container = (Composite) super.createDialogArea(parent);
//		GridLayout layout = new GridLayout(1, false);
//		layout.marginRight = 5;
//		layout.marginLeft = 10;
//		container.setLayout(layout);
		
		
		Button browseButton = new Button(container, SWT.PUSH);
		browseButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,false));
		browseButton.setText("Select path for the target platform");
		//browseButton.setAlignment(SWT.RIGHT);
		
		
	    final Text outputPathText = new Text(container, SWT.BORDER);
		outputPathText.setEditable(false) ;
	    GridData grd = new GridData();
	    grd.widthHint = TEXT_FIELD_WIDTH;
	    outputPathText.setLayoutData(grd) ;
	    
		browseButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
	    		DirectoryDialog ddg = new DirectoryDialog(getShell());
	    		File selectedFile = null;
	    		String file = ddg.open();
	    		if(file != null && file.length() > 2)
	    		{
	    			selectedFile = new File(file);
	    			outputPathText.setText(selectedFile.getAbsolutePath());
	    		}
				System.out.println("Select path for the target platform");
			}
		});
	
		return container;

	}
	
	protected Control createButtonBar(Composite parent)
	{
		
		createButtonsForButtonBar(container);
		return container;		
	}
	
	protected void createButtonsForButtonBar(Composite parent) 
	{
		createButton(parent, IDialogConstants.OK_ID, "Ok", true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("Selection dialog");
	}

	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	/**
	 * @return the msgButton
	 */
	public String getMsgButton() {
		return msgButton;
	}

	/**
	 * @return the platformType
	 */
	public String getPlatformType() {
		return platformType;
	}

	
}
