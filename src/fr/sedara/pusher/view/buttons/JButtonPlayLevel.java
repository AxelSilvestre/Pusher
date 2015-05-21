package fr.sedara.pusher.view.buttons;

import javax.swing.JButton;

import fr.sedara.pusher.controller.LevelFileManager;
import fr.sedara.pusher.model.Board;
import fr.sedara.pusher.view.JPanelGame;
import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JButtonPlayLevel extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    private String fileName;
    private final TaskDisplay taskDisplay;

    public JButtonPlayLevel(TaskDisplay taskDisplay) {
        super("Jouer");
        fileName = "";
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (!fileName.equalsIgnoreCase("")) {
            Board c = null;
            try {
                c = LevelFileManager.load(fileName);
            }
            catch (ClassNotFoundException e1) {}
            catch (IOException e1) {}
            JPanelGame j = new JPanelGame(c, taskDisplay);
            taskDisplay.getController().createNewGame(c, fileName);
            taskDisplay.setKeyListener();
            taskDisplay.gamePanel = j;
            taskDisplay.frame.setContentPane(j);
            taskDisplay.frame.setSize(j.getChamps().getX() * 50, j.getChamps().getY() * 50 + 200);
            taskDisplay.frame.setLocationRelativeTo(null);            
            taskDisplay.frame.requestFocusInWindow();
            taskDisplay.frame.revalidate();
            

        }

    }

    public void setFileName(String name) {
        fileName = name;
    }


}
