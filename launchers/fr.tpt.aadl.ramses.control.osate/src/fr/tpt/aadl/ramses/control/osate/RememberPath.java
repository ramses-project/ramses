package fr.tpt.aadl.ramses.control.osate;

import java.io.File;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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

public class RememberPath extends TitleAreaDialog {

	private Button browseFileButton;
	private Text outputPathText;
	private Label lblPath;
	private String PathForTarget;
	private String target;

	public RememberPath(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Custom dialog");
		setMessage("This is a target platform selection path dialog", IMessageProvider.INFORMATION);
		PathForTarget = "";
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(1, false);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(layout);

		createFirstName(container);
		createLastName(container);

		return area;
	}

	private void createFirstName(Composite container) {

		browseFileButton = new Button(container, SWT.PUSH);
		browseFileButton.setText("Select path for the target platform");
		browseFileButton.setAlignment(SWT.LEFT);

		browseFileButton.addSelectionListener(new SelectionAdapter()
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
					lblPath.setText("Path selected ...");
				}
			}
		});
	}

	private void createLastName(Composite container) {

		lblPath = new Label(container, SWT.NONE);
		lblPath.setText("Path not selected");

		GridData dataLastName = new GridData();
		dataLastName.grabExcessHorizontalSpace = false;
		dataLastName.horizontalAlignment = GridData.FILL;
		outputPathText = new Text(container, SWT.BORDER);
		outputPathText.setLayoutData(dataLastName);
	}



	@Override
	protected boolean isResizable() {
		return true;
	}

	// save content of the Text fields because they get disposed
	// as soon as the Dialog closes
	private void saveInput() {
		PathForTarget = outputPathText.getText();

	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getPathForTarget() {
		return PathForTarget;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
} 