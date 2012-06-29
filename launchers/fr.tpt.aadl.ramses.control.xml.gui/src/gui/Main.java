package gui;
import gui.controllers.InfoPanController;
import gui.controllers.WorkFlowFromFileController;
import gui.controllers.WorkflowPanelController;
import gui.views.MainView;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/** 
 * XML Creator. Used to graphically build and generate an xml
 * file that describes the workflow of the RAMSES code generator 
 * 
 * @author Jean Cornic
 * @author Jonatan Dahl
 * @author Thibault Fran�ois
 */
public class Main {
 
//		final static JFrame mainView = new JFrame();
		public static JScrollPane scroll = null;
		public static MainView mainView = new MainView();
		
        public static void main(String[] args){
                  
                /**
                 * Instantiate the left panel that shows the workflow tree
                 */
                WorkflowPanelController workPan = new WorkflowPanelController();
                scroll = new JScrollPane(workPan);

                JScrollBar hScrollBar = scroll.getHorizontalScrollBar();
                JScrollBar vScrollBar = scroll.getVerticalScrollBar();

                hScrollBar.addAdjustmentListener(new AdjustmentListener(){
                    public void adjustmentValueChanged(AdjustmentEvent ae1){
                        mainView.repaint();
                    }
                });
                vScrollBar.addAdjustmentListener(new AdjustmentListener(){
                    public void adjustmentValueChanged(AdjustmentEvent ae2){
                        mainView.repaint();
                    }
                });
                
                
                /**
                 * Instantiate the right panel that holds the lists of
                 * transformations and analyses
                 */
                InfoPanController info = new InfoPanController();
                workPan.setInfoPan(info);
                mainView.add(scroll);
                mainView.add(Box.createRigidArea(new Dimension(3,0)));
                mainView.add(info);
                
                /**
                 * Create the menu bar
                 */
                JMenu fileMenu = new JMenu("File");
                JMenuItem open = new JMenuItem("Open XML File");
                open.setMnemonic('O');
                
                open.addActionListener(new WorkFlowFromFileController(workPan));
                fileMenu.add(open);
                
                JMenuItem quit = new JMenuItem("Quit");
                quit.addActionListener(new ActionListener(){
        			public void actionPerformed(ActionEvent arg0) {
        				System.exit(0);
        			}				
        		});
                quit.setMnemonic('Q');
                fileMenu.add(quit);

                JMenuBar menuBar = new JMenuBar();
                menuBar.add(fileMenu);

                mainView.setJMenuBar(menuBar);
                mainView.pack();
                mainView.setVisible(true);
        } 
}