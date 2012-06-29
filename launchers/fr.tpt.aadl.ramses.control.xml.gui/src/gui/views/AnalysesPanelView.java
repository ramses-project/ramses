package gui.views;

import java.awt.Dimension;

public class AnalysesPanelView extends ListPanelView {

	private static final long serialVersionUID = 1L;

	public AnalysesPanelView(String title) {
		super(title);
		setSize(300,60);
		setPreferredSize(new Dimension(300,60));
		setMaximumSize(new Dimension(300,60));
	}
}
