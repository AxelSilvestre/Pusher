package fr.sedara.pusher.view.buttons;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.sedara.pusher.controller.LevelFileManager;
import fr.sedara.pusher.view.JFrameNameAsker;
import fr.sedara.pusher.view.JOptionPaneOverwriteLevel;
import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class JButtonValidateName extends JButton implements ActionListener {

    private JTextField      field;
    private JFrameNameAsker current;
    private final TaskDisplay taskDisplay;

    public JButtonValidateName(JTextField textField, JFrameNameAsker currentFrame, TaskDisplay taskDisplay) {
        super(taskDisplay.getController().getString("apply"));
        field = textField;
        current = currentFrame;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (!field.getText().equalsIgnoreCase("")) {
            File folder = new File("Levels");
            String[] list = folder.list();
            for (String str : list) {
                if ((field.getText() + ".Plvl").equalsIgnoreCase(str)) {
                    new JOptionPaneOverwriteLevel(current, field.getText(), taskDisplay);
                    return;
                }
            }

            try {
                LevelFileManager.save(taskDisplay.editorPanel.getChamps(), field.getText());
            }
            catch (IOException e1) {}
            current.dispose();
            current.setState(JFrame.EXIT_ON_CLOSE);
            taskDisplay.frame.toFront();
            taskDisplay.frame.setEnabled(true);

        }

    }

}
