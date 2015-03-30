package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.TaskDisplay;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonQuit extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;

    public JButtonQuit() {
        super("Quitter");
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        TaskDisplay.frame.dispose();
        TaskDisplay.frame.setState(JFrame.EXIT_ON_CLOSE);
    }


}
