package fr.sedara.Pusher.Display;

import java.awt.Dimension;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonPlayLevel;

public class JPanelChooseLevel extends JPanel implements ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private JList<String> jl;
	private JButtonPlayLevel play;
	
	public JPanelChooseLevel() {		
		File folder = new File("Levels");
		String[] list = folder.list();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		String toRemove=  ".Plvl";
		for(String str : list){
			if(str.endsWith(toRemove))
				dlm.addElement(str.replace(toRemove, ""));
		}
		jl = new JList<String>(dlm);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl.addListSelectionListener(this);
		scroll = new JScrollPane(jl);
		scroll.setPreferredSize(new Dimension(500,500));
		add(scroll);
		play = new JButtonPlayLevel();
		add(play);
		add(new JButtonCancel());
	}

	public void valueChanged(ListSelectionEvent e) {
		play.setFileName(jl.getSelectedValue()+".Plvl");
	}	

}
