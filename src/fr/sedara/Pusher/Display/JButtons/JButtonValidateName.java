package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.JFrameNameAsker;
import fr.sedara.Pusher.Display.TaskDisplay;
import fr.sedara.Pusher.LevelFileManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class JButtonValidateName extends JButton implements ActionListener {

    JTextField      field;
    JFrameNameAsker current;
    int             rank;

    public JButtonValidateName(JTextField textField, JFrameNameAsker currentFrame) {
        super("Valider");
        field = textField;
        current = currentFrame;
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (!field.getText().equalsIgnoreCase("")) {
            File folder = new File("Levels");
            String[] list = folder.list();
            for (String str : list) {
                if ((field.getText() + ".Plvl").equalsIgnoreCase(str)) {
                    current.getLabel().setText("<html>Le niveau est d�j� existant.<br>Choisissez un autre nom.</html>");
                    return;
                }
            }

            try {
                LevelFileManager.save(TaskDisplay.editorPanel.getChamps(), field.getText());
            }
            catch (IOException e1) {}
            current.dispose();
            current.setState(JFrame.EXIT_ON_CLOSE);
            TaskDisplay.frame.toFront();
            TaskDisplay.frame.setEnabled(true);

        }

    }

}
