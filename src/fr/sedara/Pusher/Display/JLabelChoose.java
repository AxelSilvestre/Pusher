package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Type;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class JLabelChoose extends JLabel implements MouseListener {

    private Type         type;
    private JChoosePanel panel;

    public JLabelChoose(Type type, JChoosePanel panel) {
        this.type = type;
        this.panel = panel;
        setPreferredSize(new Dimension(30, 30));
        setOpaque(true);
        setBackground(type.getColor());
        addMouseListener(this);

    }

    public Type getType() {
        return type;
    }

    public void mouseClicked(MouseEvent e) {
    	if(panel.exisitingPlayer() && type == Type.PLAYER)
    		panel.setWarning("<html>Joueur déjà<br>présent<html>");
    	else{
    		panel.setSelectedType(type);
    		panel.setWarning("");
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
