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
		super();
		this.type = type;
		this.panel = panel;
		setPreferredSize(new Dimension(20,20));
		setOpaque(true);
		setBackground(Type.getColor(type));
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
