package fr.sedara.pusher.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.sedara.pusher.view.buttons.JButtonCancel;
import fr.sedara.pusher.view.buttons.JButtonValidateName;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class JFrameNameAsker extends JFrame {

    private JLabel              label;
    private JPanel              jPanel;
    private JTextField          jTextField;
    private JButtonCancel       jButtonCancel;
    private JButtonValidateName validate;


    public JFrameNameAsker(TaskDisplay taskDisplay) {
        jPanel = new JPanel();
        label = new JLabel("<html>Saisissez le nom de votre niveau:</html>");
        label.setPreferredSize(new Dimension(250, 50));
        jPanel.add(label);
        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(250, 30));
        jPanel.add(jTextField);
        validate = new JButtonValidateName(jTextField, this, taskDisplay);
        jPanel.add(validate);
        jButtonCancel = new JButtonCancel(this, taskDisplay);
        jPanel.add(jButtonCancel);
        add(jPanel);
        setLocationRelativeTo(null);
        setSize(300, 200);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        taskDisplay.frame.setEnabled(false);
    }

    public JLabel getLabel() {
        return label;
    }

}
