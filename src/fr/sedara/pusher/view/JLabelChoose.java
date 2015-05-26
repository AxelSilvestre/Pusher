package fr.sedara.pusher.view;

import javax.swing.JLabel;

import fr.sedara.pusher.model.Type;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class JLabelChoose extends JLabel implements MouseListener {

    private Type         type;
    private JChoosePanel panel;
    private TaskDisplay taskDisplay;

    public JLabelChoose(Type type, JChoosePanel panel, TaskDisplay taskDisplay) {
        this.type = type;
        this.panel = panel;
        this.taskDisplay = taskDisplay;
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
    		panel.setWarning(taskDisplay.getController().getString("presentplayer"));
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
