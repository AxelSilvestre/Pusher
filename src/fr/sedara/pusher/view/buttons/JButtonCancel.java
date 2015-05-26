package fr.sedara.pusher.view.buttons;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonCancel extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JFrame  frameToClose;
    private boolean home;
    private final TaskDisplay taskDisplay;

    public JButtonCancel(boolean home, TaskDisplay taskDisplay) {
        setText(taskDisplay.getController().getString("cancel"));
        frameToClose = null;
        this.home = home;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public JButtonCancel(JFrame frameToClose, TaskDisplay taskDisplay) {
        setText(taskDisplay.getController().getString("cancel"));
        this.frameToClose = frameToClose;
        home = false;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }
    
    public JButtonCancel(JFrame frameToClose, boolean home, TaskDisplay taskDisplay) {
        setText(taskDisplay.getController().getString("home"));
        this.frameToClose = frameToClose;
        this.home = home;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }
    
    public JButtonCancel(JFrame frameToClose, boolean home, String text, TaskDisplay taskDisplay) {
        setText(text);
        this.frameToClose = frameToClose;
        this.home = home;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (frameToClose != null) {
            frameToClose.dispose();
            frameToClose.setState(JFrame.EXIT_ON_CLOSE);
        }
        if (home) {
            taskDisplay.frame.setContentPane(taskDisplay.home);
            taskDisplay.frame.setSize(200, 200);
            taskDisplay.frame.setLocationRelativeTo(null);           
        }
        taskDisplay.frame.setEnabled(true);
        taskDisplay.frame.revalidate();
        taskDisplay.frame.toFront();

    }

	public JFrame getFrameToClose() {
		return frameToClose;
	}

	public void setFrameToClose(JFrame frameToClose) {
		this.frameToClose = frameToClose;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

}
