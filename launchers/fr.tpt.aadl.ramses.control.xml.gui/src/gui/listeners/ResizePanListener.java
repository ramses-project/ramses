package gui.listeners;

import gui.controllers.WorkflowPanelController;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Class that will recalculate position of the tree when we resize the panel
 */
public class ResizePanListener implements ComponentListener{

	WorkflowPanelController workflowPan;
	
	public ResizePanListener(WorkflowPanelController pan) {
		workflowPan = pan;
	}
	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		workflowPan.changePositions();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}

}
