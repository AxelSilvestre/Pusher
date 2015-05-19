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
    private final TaskDisplay taskDisplay;

    public JButtonOpenFile(JFrame currentFrame, TaskDisplay taskDisplay) {
        super("Ouvrir");
        current = currentFrame;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public JButtonOpenFile( TaskDisplay taskDisplay) {
        super("Ouvrir");
        current = null;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (current != null) {
            current.dispose();
            current.setState(JFrame.EXIT_ON_CLOSE);
            try {
                taskDisplay.editorPanel = new JPanelEditor(LevelFileManager.load(fileName), taskDisplay);
            }
            catch (ClassNotFoundException e1) {}
            catch (IOException e1) {}
            taskDisplay.frame.setContentPane(taskDisplay.editorPanel);
            taskDisplay.frame.setEnabled(true);
            taskDisplay.frame.toFront();
            taskDisplay.frame.revalidate();
        }
        else {
            new JFrameEditorChooseLevel(taskDisplay);
        }
    }

    public void setFileName(String name) {
        fileName = name;
    }

}
