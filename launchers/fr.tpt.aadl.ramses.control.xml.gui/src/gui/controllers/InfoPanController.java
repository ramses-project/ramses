package gui.controllers;
import gui.models.ListPanelModel;
import gui.views.AnalysesPanelView;
import gui.views.InstancesPanView;
import gui.views.TransPanelView;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * This is the right column that holds three panels that 
 * shows available transformations, available 
 * analyses and current items in the tree
 */
public class InfoPanController extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Transformation panel controller, will take two arguments to instanciate:
	 * TransPanelView and ListPanelModel
	 */
	private TransPanelController transPanel;
	/**
	 * Analyses panel controller, will take two arguments to instanciate:
	 * AnalysesPanelView and ListPanelModel
	 */
	private AnalysesPanelController analysesPanel;
	/**
	 * The panel that shows what instances are currently assigned in the workflow tree
	 */
	private InstancesPanView instancesPanel;
	
	public InfoPanController() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(200,600));
		setMaximumSize(new Dimension(300,1000));
		setPreferredSize(new Dimension(300,600));
		
		transPanel = new TransPanelController(
							new TransPanelView("Available transformations"), 
							new ListPanelModel());

		transPanel.loadDefaultTransformations();
		
		analysesPanel = new AnalysesPanelController(
							new AnalysesPanelView("Available analyses"), 
							new ListPanelModel());
		
		analysesPanel.loadDefaultAnalyses();
		
		instancesPanel = new InstancesPanView();
        add(transPanel.getView());
        add(Box.createRigidArea(new Dimension(0,3)));
        add(analysesPanel.getView());
        add(Box.createRigidArea(new Dimension(0,3)));
        add(instancesPanel);
	}
	
	public Vector<String> getTransformations() {
		return transPanel.getTransformations();
	}
	
	public Vector<String> getAnalyses() {
		return analysesPanel.getAnalyses();
	}
	
	public InstancesPanView getInstancesPanel() {
		return instancesPanel;
	}
}
