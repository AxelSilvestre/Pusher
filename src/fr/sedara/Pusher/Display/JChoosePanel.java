package fr.sedara.Pusher.Display;

import javax.swing.JPanel;

import fr.sedara.Pusher.Type;

@SuppressWarnings("serial")
public class JChoosePanel extends JPanel{

//	private JLabel player;
//	private JLabel wall;
//	private JLabel playable_block;
//	private JLabel deadly;
//	private JLabel breakable;
//	private ImageIcon playerIcon = new ImageIcon("icons/player.png");
//	private ImageIcon wallIcon = new ImageIcon("icons/wall.png");
//	private ImageIcon playableIcon = new ImageIcon("icons/playable.png");
//	private ImageIcon deadlyIcon = new ImageIcon("icons/deadly.png");
//	private ImageIcon breakableIcon = new ImageIcon("icons/breakable.png");
	private JPanelEditor editor;
	
	public JChoosePanel(JPanelEditor editor) {
		super();
		this.editor = editor;
		for(int i=0;i<5;i++){
			JLabelChoose jl = new JLabelChoose(Type.getType(i),this);
			add(jl);
		}
		
	}

	public void setSelectedType(Type selectedType) {
		editor.setSelectedType(selectedType);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
