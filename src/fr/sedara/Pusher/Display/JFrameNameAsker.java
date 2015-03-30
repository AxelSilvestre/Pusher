package fr.sedara.Pusher.Display;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonValidateName;

@SuppressWarnings("serial")
public class JFrameNameAsker extends JFrame{

	private JLabel label;
	private JPanel jPanel;
	private JTextField jTextField;
	private JButtonCancel jButtonCancel;
	private JButtonValidateName validate;
	
	
	public JFrameNameAsker() {
		jPanel = new JPanel();
		label = new JLabel("<html>Saisissez le nom de votre niveau:</html>");
		label.setPreferredSize(new Dimension(250,50));
		jPanel.add(label);
		jTextField = new JTextField();
		jTextField.setPreferredSize(new Dimension(250,30));
		jPanel.add(jTextField);
		validate = new JButtonValidateName(jTextField, this);
		jPanel.add(validate);
		jButtonCancel = new JButtonCancel(this);
		jPanel.add(jButtonCancel);
		add(jPanel);
		setLocationRelativeTo(null);
		setSize(300, 200);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
}
