package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Case;
import fr.sedara.Pusher.Type;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class JLabelCase extends JLabel implements MouseListener {

    private Case c;

    private TaskDisplay taskDisplay;
    
    public JLabelCase(Case c, boolean edit, TaskDisplay taskDisplay) {
    	this.taskDisplay = taskDisplay;
        this.c = c;
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(c.getType().getColor());
        if (edit) { addMouseListener(this); }
    }

    public void setColor() {
        setBackground(c.getType().getColor());
    }

    public Case getC() {
        return c;
    }

    public void mouseClicked(MouseEvent e) {
        if (taskDisplay.editorPanel.getSelectedType() != null) {
            c.setType(taskDisplay.editorPanel.getSelectedType());
        	if(taskDisplay.editorPanel.getSelectedType() == Type.PLAYER)
            	taskDisplay.editorPanel.setSelectedType(null);
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
