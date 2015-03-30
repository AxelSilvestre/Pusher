package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.TaskDisplay;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonCancel extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JFrame  frameToClose;
    //	private JFrame previousFrame;
    private boolean home;


    public JButtonCancel() {
        setText("Annuler");
        frameToClose = null;
        //		previousFrame = null;
        home = false;
        addActionListener(this);
    }

    public JButtonCancel(boolean home) {
        setText("Annuler");
        frameToClose = null;
        //		previousFrame = null;
        this.home = home;
        addActionListener(this);
    }

    public JButtonCancel(JFrame frame) {
        setText("Annuler");
        frameToClose = frame;
        //		previousFrame = null;
        home = false;
        addActionListener(this);
    }

    //	public JButtonCancel(JFrame frame, JFrame previous){
    //		setText("Annuler");
    //		frameToClose = frame;
    //		previousFrame = previous;
    //		home = false;
    //	}

    public JButtonCancel(JFrame frame, boolean home) {
        setText("Menu principal");
        frameToClose = frame;
        //		previousFrame = null;
        this.home = home;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (frameToClose != null) {
            frameToClose.dispose();
            frameToClose.setState(JFrame.EXIT_ON_CLOSE);
        }
        if (home) {
            TaskDisplay.frame.setContentPane(TaskDisplay.home);
            TaskDisplay.frame.setSize(200, 200);
            TaskDisplay.frame.setLocationRelativeTo(null);
        }
        //		if(previousFrame != null)
        //			TaskDisplay.frame.setContentPane(previousFrame);
        TaskDisplay.frame.setEnabled(true);
        TaskDisplay.frame.revalidate();
        TaskDisplay.frame.toFront();

    }

}
