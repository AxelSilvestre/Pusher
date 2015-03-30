package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Case;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class JLabelCase extends JLabel implements MouseListener {

    private Case c;

    public JLabelCase(Case c, boolean edit) {
        this.c = c;
        setOpaque(true);
        //setPreferredSize(new Dimension(50,50));
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
        if (TaskDisplay.editorPanel.getSelectedType() != null) {
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
