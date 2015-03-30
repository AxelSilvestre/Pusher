package fr.sedara.Pusher.Display;

import java.awt.Dimension;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.sedara.Pusher.Display.JButtons.JButtonOpenFile;

public class JFrameEditorChooseLevel extends JFrame implements ListSelectionListener{
	
	private static final long serialVersionUID = 1L;

	private JScrollPane scroll;
	private JList<String> jl;
	private JButtonOpenFile open;

	public JFrameEditorChooseLevel() {
		File folder = new File("Levels");
		String[] list = folder.list();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		String toRemove = ".Plvl";
		for(String str : list){
			if(str.endsWith(toRemove))
				dlm.addElement(str.replace(toRemove, ""));
		}
		jl = new JList<String>(dlm);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl.addListSelectionListener(this);
		scroll = new JScrollPane(jl);
		scroll.setPreferredSize(new Dimension(100, 300));
		JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jsp.add(scroll);
		open = new JButtonOpenFile(this);
		jsp.add(open);
		jsp.setDividerSize(0);			
		add(jsp);
		setSize(100,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		TaskDisplay.frame.setEnabled(false);
		setLocationRelativeTo(null);
		toFront();
	}

	public void valueChanged(ListSelectionEvent arg0) {
		open.setFileName(jl.getSelectedValue());
	}

}
