package fr.sedara.Pusher.Display;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonRetry;

public class JFrameEndGame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public JFrameEndGame(boolean win){
		super("Partie terminée");
		JPanel jp = new JPanel();
		JLabel jl = new JLabel(win ? "<html>Vous avez terminé ce <br> niveau avec succés!<html>" : "Vous avez perdu!");
		jp.add(jl);
		JButtonCancel menu = new JButtonCancel(this, true);
		JButtonRetry retry = new JButtonRetry(this);
		jp.add(retry);
		jp.add(menu);
		add(jp);
		toFront();
		TaskDisplay.frame.setEnabled(false);
		
		setSize(200, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
	}
	

}
