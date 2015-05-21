package fr.sedara.pusher.view.buttons;

import javax.swing.JButton;

import fr.sedara.pusher.view.JFrameNameAsker;
import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JButtonValidateEdition extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private final TaskDisplay taskDisplay;

    public JButtonValidateEdition(TaskDisplay taskDisplay) {
        setText("Valider");
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        taskDisplay.frame.setEnabled(false);
        new JFrameNameAsker(taskDisplay);

    }

}
