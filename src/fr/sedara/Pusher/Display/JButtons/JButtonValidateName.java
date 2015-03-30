package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.sedara.Pusher.LevelFileManager;
import fr.sedara.Pusher.Display.TaskDisplay;

@SuppressWarnings("serial")
public class JButtonValidateName extends JButton implements ActionListener{

	JTextField field;
	JFrame current;
	int rank;
	
	public JButtonValidateName(JTextField textField, JFrame currentFrame) {
		super("Valider");
		field = textField;
		current = currentFrame;
		addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(!field.getText().equalsIgnoreCase("")){
			try {
				LevelFileManager.save(TaskDisplay.editorPanel.getChamps(), field.getText());
			} catch (IOException e1) {}
			current.dispose();
			current.setState(JFrame.EXIT_ON_CLOSE);
			TaskDisplay.frame.toFront();
			TaskDisplay.frame.setEnabled(true);
			
		}

	}

}
