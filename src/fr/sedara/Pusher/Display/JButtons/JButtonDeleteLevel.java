package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.JFrameEditorChooseLevel;
import fr.sedara.Pusher.Display.JPanelEditor;
import fr.sedara.Pusher.Display.TaskDisplay;
import fr.sedara.Pusher.Champs;
import fr.sedara.Pusher.LevelFileManager;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
        	try {
				if(TaskDisplay.editorPanel.getChamps().equals(LevelFileManager.load(fileName)))
					TaskDisplay.editorPanel = new JPanelEditor(new Champs());
			} catch (ClassNotFoundException e1) {} catch (IOException e1) {}
            LevelFileManager.delete(fileName);
            current.setContentPane(new JFrameEditorChooseLevel());
            TaskDisplay.frame.revalidate();
        }
    }

    public void setFileName(String name) {
        fileName = name;
    }


}
