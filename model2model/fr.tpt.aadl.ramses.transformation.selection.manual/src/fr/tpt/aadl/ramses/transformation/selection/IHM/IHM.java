package fr.tpt.aadl.ramses.transformation.selection.IHM; 


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTulpe;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils;


public class IHM extends JFrame implements ItemListener,ActionListener,Serializable,MenuListener,WindowListener{


	final JRootPane rootPane; // = new JRootPane();
	
	private JPanel contentPane;
	private AlternativePanel[] alternativePanel;
//	private boolean[] AlternativeDecisionIsMade;
	private JComboBox alternativeNumber;
	private JComboBox alternativeRules;
	private JLabel alternativeLabel;

	
	private JComboBox[] alternativeJcomboElement ; 
	private List<List<String>> alternativeString;
	
	final JRootPane comboBoxPanel;
	private JButton applyAlternative;
	private List<List<TaggedRuleApplicationTulpe>> TaggedRuleApplicationT =  new ArrayList<List<TaggedRuleApplicationTulpe>>();

	private boolean comboBoxItemChangeListenerIsActive = true;
	private int NumberOfAlternative =0 ;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmValidate = new JMenuItem("Validate");
	private JMenuItem mntmExit = new JMenuItem("Exit");
	private JMenuItem mntmExport = new JMenuItem("Export");
	private JMenuItem mntmImport = new JMenuItem("Import");
	private JFrame thisJFrame; 

	/**
	 * Create the frame.
	 */
	public IHM(TrcSpecification trc)   {
		
		thisJFrame = this; 
	//	 PrintEobjectNames();
		GlobalVariables.trc = trc ;
	
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		this.addWindowListener(this);
		
		setJMenuBar(menuBar);
		menuBar.add(mnFile);
		mnFile.add(mntmValidate);
		mnFile.add(mntmExport);
		mnFile.add(mntmImport);
		mnFile.add(mntmExit);
		
		mntmExit.addActionListener(this);
		mnFile.addMenuListener(this);
		mntmValidate.addActionListener(this);
		mntmImport.addActionListener(this);
		mntmExport.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);
		setVariableContent();
		
		alternativePanel = new AlternativePanel[GlobalVariables.toIHM.size()];
		
		for(int j=0;j<GlobalVariables.toIHM.size();j++)
			 alternativePanel[j] = new AlternativePanel();
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		contentPane.add(splitPane, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Alternative     ");
		JPanel leftPanel = new JPanel(new GridLayout(0,1,3,3));
		leftPanel.add(lblNewLabel);
		alternativeNumber.addItemListener(this);
		leftPanel.add(alternativeNumber);	
		applyAlternative = new JButton("Apply");
		applyAlternative.addActionListener(this);
		leftPanel.add(applyAlternative);
		splitPane.setLeftComponent(leftPanel);	
		
		comboBoxPanel = new JRootPane(); 
		alternativeRules = new JComboBox();
		alternativeLabel = new JLabel("Choose alternative");
		JPanel rightPanel = new JPanel(new GridLayout(0,1,3,3));
		rightPanel.add(alternativeLabel);
		rightPanel.add(comboBoxPanel);
		splitPane.setRightComponent(rightPanel);
		
		alternativeRules = alternativeJcomboElement[0] ;
		
		rootPane = new JRootPane();
		rootPane.setBorder(new TitledBorder(null, "Consequences", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		//JPanel bigPanel= new JPanel(new CardLayout());				
		JScrollPane scrollPane = new JScrollPane(rootPane);
		//scrollPane.setViewportBorder(new LineBorder(Color.BLUE));
		contentPane.add(scrollPane, BorderLayout.CENTER);

		
		String alternativeObjects="FOR { "+printAllObjects(getEObjectList(0));
		alternativeObjects +=" } SELECT: ";
		setAlternative(alternativeObjects);
		comboBoxPanel.setContentPane(alternativeJcomboElement[0]);
		
	}
	
	public JPanel getContentPane(){
		return contentPane;
	}
	
	
	public void PrintEobjectNames(){
		Iterator<Entry<EObject,String>> EObject_EObjectKey_Element = GlobalVariables.EObjectList_EObjectKey.entrySet().iterator();
		for (Iterator iterator = EObject_EObjectKey_Element; iterator.hasNext();)
		{
			Map.Entry<EObject,String> tuple = (Map.Entry<EObject,String>)iterator.next();
			EObject EobjectRef = tuple.getKey(); 
			String EObjectName = tuple.getValue();
			if(EobjectRef instanceof NamedElement ){
				System.out.println("EObject { "+ ((NamedElement) EobjectRef).getQualifiedName()+ " }" + "Name: "+ EObjectName );
			}
			else {
				System.out.println("EObject { "+  EobjectRef.getClass().getName()+ " }" + "Name: "+ EObjectName );

			}	
		}
	}	
	
	public void PrintEobjectNames2(){
		Iterator<Entry<String,EObject>> EObjectList_NameKey_Element = GlobalVariables.EobjectList_NameKey.entrySet().iterator();
		for (Iterator iterator = EObjectList_NameKey_Element; iterator.hasNext();)
		{
			Map.Entry<String,EObject> tuple = (Map.Entry<String,EObject>)iterator.next();
			EObject EobjectRef = tuple.getValue();
			String EObjectName =  tuple.getKey();  
			if(EobjectRef instanceof NamedElement ){
				System.out.println("EObject { "+ ((NamedElement) EobjectRef).getQualifiedName()+ " }" + "Name: "+ EObjectName );
			}
			else {
				System.out.println("EObject { "+  EobjectRef.getClass().getName()+ " }" + "Name: "+ EObjectName );

			}	
		}
	}	
	
	private void setVariableContent() {
		
		NumberOfAlternative =  GlobalVariables.toIHM.size();
		int i= 0 ;
		alternativeJcomboElement = new JComboBox[NumberOfAlternative];
		alternativeString = new ArrayList<List<String>>() ;
		List<String> elements = new ArrayList<String>(); 
		alternativeNumber = new JComboBox();
		
		Iterator<Entry<List<EObject>, List<String>>> ihmVariables = GlobalVariables.toIHM.entrySet().iterator();
		for (Iterator iterator = ihmVariables; iterator.hasNext();) {
			Map.Entry<List<EObject>, List<String>> tuple = (Map.Entry<List<EObject>, List<String>>)iterator.next();
			List<String> candidateTransformationList = tuple.getValue();
			List<EObject> candidateObjects = tuple.getKey();
			alternativeJcomboElement[i] = new JComboBox();
			for (int k = 0; k < candidateObjects.size(); k++){
				elements.add(GlobalVariables.EObjectList_EObjectKey.get(candidateObjects.get(k)));
			}
			alternativeString.add(elements); 
			for (int j = 0; j < candidateTransformationList.size(); j++){
				alternativeJcomboElement[i].addItem(candidateTransformationList.get(j));
			}
			alternativeNumber.addItem(i+1);
			i++;
		}
		
	}


	public void setAlternative(String text){
		alternativeLabel.setText(text);
	}
	
	public void setPanel(int i){
		rootPane.setContentPane(alternativePanel[i].getAlternativePanel());
	}
	
	public String getKeyByValue(EObject object){
		Iterator<Entry<String,EObject>> EObject_NameKey_Element = GlobalVariables.EobjectList_NameKey.entrySet().iterator();
		for (Iterator iterator = EObject_NameKey_Element; iterator.hasNext();)
		{
			Map.Entry<String,EObject> tuple = (Map.Entry<String,EObject>)iterator.next();
			EObject EobjectRef = tuple.getValue();
			String EObjectName = tuple.getKey();
			if(object == EobjectRef ){
				return EObjectName;
			}
		}
		return null;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
	       if (e.getStateChange() == ItemEvent.SELECTED && comboBoxItemChangeListenerIsActive) {
	    	 int index= alternativeNumber.getSelectedIndex();
			 String alternativeObjects="FOR { "+printAllObjects(getEObjectList(index));
			 alternativeObjects +=" } SELECT: ";
			 setAlternative(alternativeObjects);
			 comboBoxPanel.setContentPane(alternativeJcomboElement[index]);
			 comboBoxPanel.validate();   
			 rootPane.setContentPane(alternativePanel[index].getAlternativePanel());
			 rootPane.validate();	
	       }	
	}
	
	public  List<EObject> getEObjectList(int index){
		int i=0;
		for(List<EObject> o : GlobalVariables.toIHM.keySet()){
	        if(i==index) return o;
	        i++;
	    }
	    return null;	
	}
	
	public List<String> getRulesList(int index){
		int i=0;
		for(List<String> o : GlobalVariables.toIHM.values()){
	        if(i==index) return o;
	        i++;
	    }
	    return null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 int index= alternativeNumber.getSelectedIndex();
		 
		  if(e.getSource() == mntmValidate){
				System.out.println("mntmValidate clicked");	
				printRules();
				
				if(checkIfAllDecisionAreMade())	{
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you shure you want to validate your choices ?","Validate", JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						 synchronized (GlobalVariables.lock) {
							 GlobalVariables.doneSelecting = true;
							 GlobalVariables.lock.notify();
					         }
						GlobalVariables.JFrameIsClosed=true;
						thisJFrame.dispose();		
					}
				}
				
				else {
					JOptionPane.showMessageDialog(this,
        				    "You can't validate now!\nPlease continue all alternatives",
        				    "Validation warning",
        				    JOptionPane.WARNING_MESSAGE);
				}
		 }
		  else if(e.getSource() == mntmExit){
				System.out.println("mntmExit clicked");
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you shure you want to close the application ?","Warning", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					 synchronized (GlobalVariables.lock) {
						 GlobalVariables.doneSelecting = false;
						 GlobalVariables.lock.notify();
				         }
					GlobalVariables.JFrameIsClosed=true;
					thisJFrame.dispose();		
				}				
			}
		  else if(e.getSource() == mntmExport){
			  serialize();		  
		  }
		  else if (e.getSource() == mntmImport){
			  deserialize();
		  }
		  else{		  
			 if( e.getSource() == applyAlternative )
		        {	
				 alternativePanel[index].RemoveAllPanel();
				 TaggedRuleApplicationT = TrcUtils.getNormalizedDependencies(GlobalVariables.trc,getEObjectList(index) ,alternativeJcomboElement[index].getSelectedItem().toString() );
				 //printListList(TaggedRuleApplicationT,Integer.toString(index));
				 alternativePanel[index].SetAlternative(TaggedRuleApplicationT,index);
				 rootPane.setContentPane(alternativePanel[index].getAlternativePanel());
				 rootPane.validate();
		        }	
	
			 addSubButtonListener(alternativePanel[index].getAlternativePanel());
			 IfNoMoreDecision(index);
		  }
		 
	}
	
	public void addSubButtonListener(Component c){
		if(c instanceof Container && !(c instanceof JButton)){
			Component[] children = ((Container) c).getComponents();
			for (Component child : children) {
				addSubButtonListener(child);
            }		
		}
		else if (c instanceof JButton){
			 ((JButton) c).addActionListener(this);

		}	
	}
	
	
	public void IfNoMoreDecision(int index){
		
		String item = (String) Integer.toString(index+1);
		comboBoxItemChangeListenerIsActive=false;
		if(alternativePanel[index].checkAllSubDecisions()){
			alternativeNumber.removeItemAt(index);
			alternativeNumber.insertItemAt(item + " Ok", index);
			alternativeNumber.setSelectedIndex(index);
			alternativePanel[index].NoMoreDecisionToTake=true;
		}
		else{
			alternativeNumber.removeItemAt(index);
			alternativeNumber.insertItemAt(item, index);
			alternativeNumber.setSelectedIndex(index);
			alternativePanel[index].NoMoreDecisionToTake=false;
		}
		comboBoxItemChangeListenerIsActive=true;
	}
	
	public boolean checkIfAllDecisionAreMade(){
		
		for(int i=0 ; i<alternativePanel.length ; i++){
			if(alternativePanel[i].NoMoreDecisionToTake == false)
				return false;
		}
		return true;
	}
	
	public void printRules(){
		//GlobalVariables.tuplesToApply.clear();
		createNewFile("RulesToApply");
		String s="";
		for (int i = 0; i < alternativePanel.length ; i++){	
			//GlobalVariables.tuplesToApply.add(new ChoosenRulesToApply(getEObjectList(i),alternativeJcomboElement[i].getSelectedItem().toString()));
			GlobalVariables.tuplesToApply.add(new ChoosenRulesToApply(getEObjectList(i),getRulesList(i),alternativeJcomboElement[i].getSelectedIndex()));
			alternativePanel[i].getAllAppliedRule();
		}
		
		for (int k = 0; k < GlobalVariables.tuplesToApply.size(); k++){	
			s +="Apply Rule "+ GlobalVariables.tuplesToApply.get(k).getChoosenRule() + " for { "+
			printAllObjects(GlobalVariables.tuplesToApply.get(k).EObjectList) + " }\n";
		}
		
		copyIntoFile("RulesToApply",s);
	}
	
	public void consequences(List<List<TaggedRuleApplicationTulpe>> taggedRuleApplicationList,int index){
		
		List<TaggedRuleApplicationTulpe> taggedRuleApplicationTuple = new ArrayList<TaggedRuleApplicationTulpe>();
		Map<List<EObject>,String> inclusionTuple = new HashMap<List<EObject>,String>();
		Map<List<EObject>,String> exclusionTuple = new HashMap<List<EObject>,String>();
		int k=0 ;
		int i=0;
		for (k = 0; k < taggedRuleApplicationList.size(); k++){		
			taggedRuleApplicationTuple.addAll(taggedRuleApplicationList.get(k));
			for (i = 0; i < taggedRuleApplicationTuple.size(); i++){
				if(!taggedRuleApplicationTuple.get(i).isExclusion()){
					exclusionTuple.put(taggedRuleApplicationTuple.get(i).getPatternMatchedElement(), taggedRuleApplicationTuple.get(i).getTransformationRuleName());
				}
				else{
					inclusionTuple.put(taggedRuleApplicationTuple.get(i).getPatternMatchedElement(), taggedRuleApplicationTuple.get(i).getTransformationRuleName());					
				}
			}
		}
		
		if(k==0){
			alternativePanel[index].AddNoConsequence();
		}

		
	}
	
	private String printAllObjects(List<EObject> eobjects){
		
		String eobject_String= "";
		for (int k = 0; k < eobjects.size(); k++){
			if(k<eobjects.size()-1) eobject_String += GlobalVariables.EObjectList_EObjectKey.get(eobjects.get(k)) +", ";
			else eobject_String +=GlobalVariables.EObjectList_EObjectKey.get(eobjects.get(k));
		}	
		return eobject_String;
	}

	public static void createNewFile(String fileName) {
		File nomFichier = new File(fileName);
		try {
			nomFichier.createNewFile();
			System.out.println(System.getProperty("user.dir"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyIntoFile(String inFile, String string2write) {
		if ((new File(inFile)).exists()) {
			BufferedWriter out;
			try {
				out = new BufferedWriter(new FileWriter(inFile));
				out.write(string2write);
				out.newLine();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Le fichier n'existe pas");
		}
	}
	
	 public void serialize() {

		  try {
		   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
		   oos.writeObject(thisJFrame);
		   oos.close();
		  } catch (Exception e) {
		   // TODO: handle exception
		   e.printStackTrace();
		  }
		 }
	 
	 public void deserialize() {

		  try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
			 JFrame frame = new JFrame();
			 frame = (JFrame) ois.readObject();	
			 frame.setVisible(true);
			 ois.close();
			 thisJFrame.dispose();
		  } catch (Exception e) {
		   // TODO: handle exception
		   e.printStackTrace();
		  }
		 }
	   
	 
	 public void save()
	   {
		 JFileChooser chooser = new JFileChooser();
	      chooser.setCurrentDirectory(new File(".")); 
	      
	      if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
	      {
	         try
	         {
	            File file = chooser.getSelectedFile();
	            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file));
	            encoder.writeObject(thisJFrame);
	            encoder.close();
	         }
	         catch (IOException e)
	         {
	            JOptionPane.showMessageDialog(null, e);
	         }
	      }
	   }

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource() == mnFile ){
//			if(checkIfAllDecisionAreMade())			
//				mntmValidate.setEnabled(true);
//			else mntmValidate.setEnabled(false);
//		System.out.println("Menu is Clicked!");
		}
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		GlobalVariables.JFrameIsClosed=true;
		System.out.println("JFrame is closed");
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you shure you want to close the application ?","Warning", JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION){
			 synchronized (GlobalVariables.lock) {
				 GlobalVariables.doneSelecting = false;
				 GlobalVariables.lock.notify();
		         }
			 GlobalVariables.JFrameIsClosed=true;
			thisJFrame.dispose();		
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}





}
