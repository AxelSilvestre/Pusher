package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Display.Menus.HomeMenu;
import fr.sedara.Pusher.TaskPlay;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class TaskDisplay extends KeyAdapter implements Runnable {

    public static JFrame       frame;
    public static JPanelGame   gamePanel;
    public static JPanelEditor editorPanel;
    public static HomeMenu     home;

    public void run() {
        frame = new JFrame();
        home = new HomeMenu();
        frame.setContentPane(home);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setEnabled(true);
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void keyReleased(KeyEvent e) {
        if (!TaskPlay.inMovement) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                TaskPlay.timer = new Timer();
                TaskPlay.timer.schedule(TaskPlay.timerTask(1, 0), 0, 100);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                TaskPlay.timer = new Timer();
                TaskPlay.timer.schedule(TaskPlay.timerTask(-1, 0), 0, 100);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                TaskPlay.timer = new Timer();
                TaskPlay.timer.schedule(TaskPlay.timerTask(0, -1), 0, 100);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                TaskPlay.timer = new Timer();
                TaskPlay.timer.schedule(TaskPlay.timerTask(0, 1), 0, 100);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                TaskPlay.caught = !TaskPlay.caught;
            }
        }
    }


}
