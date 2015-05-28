package fr.sedara.pusher.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import fr.sedara.pusher.model.Board;
import fr.sedara.pusher.view.JPanelEditor;
import fr.sedara.pusher.view.TaskDisplay;

public class JButtonChangeSize extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TaskDisplay taskDisplay;
	private JTextField jTextFieldWidht;
	private JTextField jTextFieldHeight;
	
	public JButtonChangeSize(TaskDisplay taskDisplay, JTextField jTextFieldWidht, JTextField jTextFieldHeight) {
		super(taskDisplay.getController().getString("set"));
		this.taskDisplay = taskDisplay;
		this.jTextFieldWidht = jTextFieldWidht;
		this.jTextFieldHeight = jTextFieldHeight;
		addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		int widht = Board.DEFAULT_X;
		int height = Board.DEFAULT_Y;
		
		if(!jTextFieldWidht.getText().equalsIgnoreCase(""))
			widht = Integer.valueOf(jTextFieldWidht.getText());
		
		if(!jTextFieldHeight.getText().equalsIgnoreCase(""))
			height = Integer.valueOf(jTextFieldHeight.getText());
		
		if(!jTextFieldWidht.getText().equalsIgnoreCase("") || !jTextFieldHeight.getText().equalsIgnoreCase("")){
			taskDisplay.editorPanel = new JPanelEditor(new Board(widht,height), taskDisplay);
			taskDisplay.frame.setContentPane(taskDisplay.editorPanel);
			taskDisplay.frame.revalidate();
		}
			
			
	}

}
