package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.TaskDisplay;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonCancel extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JFrame  frameToClose;
    private boolean home;

    public JButtonCancel(boolean home) {
        setText("Annuler");
        frameToClose = null;
        this.home = home;
        addActionListener(this);
    }

    public JButtonCancel(JFrame frameToClose) {
        setText("Annuler");
        this.frameToClose = frameToClose;
        home = false;
        addActionListener(this);
    }
    
    public JButtonCancel(JFrame frameToClose, boolean home) {
        setText("Menu principal");
        this.frameToClose = frameToClose;
        this.home = home;
        addActionListener(this);
    }
    
    public JButtonCancel(JFrame frameToClose, boolean home, String text) {
        setText(text);
        this.frameToClose = frameToClose;
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
        TaskDisplay.frame.setEnabled(true);
        TaskDisplay.frame.revalidate();
        TaskDisplay.frame.toFront();

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
