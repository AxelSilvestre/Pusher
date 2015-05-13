package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.sedara.Pusher.Champs;
import fr.sedara.Pusher.LevelFileManager;
import fr.sedara.Pusher.Pusher;
import fr.sedara.Pusher.Game;
import fr.sedara.Pusher.Display.JPanelGame;
import fr.sedara.Pusher.Display.TaskDisplay;

public class JButtonRetry extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;

	public JButtonRetry(JFrame frameToClose) {
		super("Recommencer");
		frame = frameToClose;
		addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
        Champs c = null;
        try {
            c = LevelFileManager.load(Game.currentLevel);
        }
        catch (ClassNotFoundException e1) {}
        catch (IOException e1) {}
        Pusher.setChamps(c);
        JPanelGame j = new JPanelGame(c);
        TaskDisplay.gamePanel = j;
        TaskDisplay.frame.setContentPane(TaskDisplay.gamePanel);
        TaskDisplay.frame.revalidate();
		TaskDisplay.frame.setEnabled(true);
		TaskDisplay.frame.toFront();
		Game.start();
		frame.dispose();
		frame.setState(JFrame.EXIT_ON_CLOSE);
		
	}

}
