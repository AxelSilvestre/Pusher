package fr.sedara.Pusher.Display;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonOpenFile;
import fr.sedara.Pusher.Display.JButtons.JButtonValidateEdition;
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
		this.editor = editor;
		JLabelChoose jl;
		JLabel name;		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.weightx = 2;
		gbc.weighty = Type.NUMBER_OF_BLOCKS+2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JButtonOpenFile(), gbc);
		for(int i=0;i<Type.NUMBER_OF_BLOCKS;i++){
			gbc.gridx = 0;
			gbc.gridy = i+1;
			jl = new JLabelChoose(Type.getType(i),this);
			name = new JLabel(jl.getType().getName());	
			add(name, gbc);
			gbc.gridx = 1;			
			add(jl, gbc);
			
		}
		gbc.gridx = 0;
		gbc.gridy++;
		add(new JButtonValidateEdition(), gbc);
		gbc.gridx = 1;
		add(new JButtonCancel(true), gbc);
		
		
	}

	public void setSelectedType(Type selectedType) {
		editor.setSelectedType(selectedType);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
