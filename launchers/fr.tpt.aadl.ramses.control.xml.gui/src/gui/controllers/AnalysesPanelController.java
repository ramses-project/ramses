package gui.controllers;

import gui.classes.ListItem;
import gui.models.ListPanelModel;
import gui.views.AnalysesPanelView;
import gui.views.ListPanelView;

import java.util.Vector;

public class AnalysesPanelController extends ListPanelController {

	AnalysesPanelView view;
	
	public AnalysesPanelController(AnalysesPanelView view_, ListPanelModel model_) {
		super((ListPanelView)view_, model_);
		view = view_;
	}

	public Vector<String> getAnalyses() {
		Vector<String> analyses = getItemStrings();
		return analyses;
	}
	
	public void loadDefaultAnalyses() {
		Vector<ListItem> defaultAnalyses = new Vector<ListItem>();
		defaultAnalyses.add(new ListItem("WCETAnalysis", ""));
		view.refreshList(defaultAnalyses);
	}
}
