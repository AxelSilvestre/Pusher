package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.JFrameEditorChooseLevel;
import fr.sedara.Pusher.Display.JPanelEditor;
import fr.sedara.Pusher.Display.TaskDisplay;
import fr.sedara.Pusher.LevelFileManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JButtonOpenFile extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    private String fileName;
    private JFrame current;

    public JButtonOpenFile(JFrame currentFrame) {
        super("Ouvrir");
        current = currentFrame;
        addActionListener(this);
    }

    public JButtonOpenFile() {
        super("Ouvrir");
        current = null;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (current != null) {
            current.dispose();
            current.setState(JFrame.EXIT_ON_CLOSE);
            try {
                TaskDisplay.editorPanel = new JPanelEditor(LevelFileManager.load(fileName));
            }
            catch (ClassNotFoundException e1) {}
            catch (IOException e1) {}
            TaskDisplay.frame.setEnabled(true);
            TaskDisplay.frame.toFront();
            TaskDisplay.frame.revalidate();
        }
        else {
            new JFrameEditorChooseLevel();
        }
    }

    public void setFileName(String name) {
        fileName = name;
    }

}
