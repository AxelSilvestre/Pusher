package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.JFrameEditorChooseLevel;
import fr.sedara.Pusher.Display.TaskDisplay;
import fr.sedara.Pusher.LevelFileManager;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonDeleteLevel extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;

    private String fileName;
    private JFrame current;

    public JButtonDeleteLevel(JFrame currentFrame) {
        super("Supprimer");
        fileName = "";
        current = currentFrame;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (!fileName.equalsIgnoreCase("")) {
            LevelFileManager.delete(fileName);
            current.dispose();
            current.setState(JFrame.EXIT_ON_CLOSE);
            TaskDisplay.frame.toFront();
            new JFrameEditorChooseLevel();
        }
    }

    public void setFileName(String name) {
        fileName = name;
    }


}
