package fr.sedara.Pusher.Display;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import fr.sedara.Pusher.Case;
import fr.sedara.Pusher.Type;

@SuppressWarnings("serial")
public class JLabelCase extends JLabel implements MouseListener{
	
	private Case c;
	private boolean edit;
	
	public JLabelCase(Case c, boolean edit) {
		super();
		this.c = c;
		setOpaque(true);
		//setPreferredSize(new Dimension(50,50));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Type.getColor(c.getType()));
		this.edit = edit;
	}
	
	public void setColor(){
		setBackground(Type.getColor(c.getType()));
	}

	public Case getC() {
		return c;
	}

	public void mouseClicked(MouseEvent e) {
		if(edit){			
			c.setType(TaskDisplay.editorPanel.getSelectedType());
			setColor();
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	

}
