package fr.sedara.Pusher.Display;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import fr.sedara.Pusher.Type;

@SuppressWarnings("serial")
public class JLabelChoose extends JLabel implements MouseListener{
	
	private Type type;
	private JChoosePanel panel;
	
	public JLabelChoose(Type type, JChoosePanel panel) {
		this.type = type;
		this.panel = panel;
		setPreferredSize(new Dimension(30,30));
		setOpaque(true);
		setBackground(type.getColor());
		addMouseListener(this);
		
	}
	
	public Type getType(){
		return type;
	}

	public void mouseClicked(MouseEvent e) {
		panel.setSelectedType(type);
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
