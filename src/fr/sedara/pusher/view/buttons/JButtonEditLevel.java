package fr.sedara.pusher.view.buttons;

import javax.swing.JButton;

import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonEditLevel extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    // TODO this

    public JButtonEditLevel(TaskDisplay taskDisplay) {
        super(taskDisplay.getController().getString("open"));
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    }

}
