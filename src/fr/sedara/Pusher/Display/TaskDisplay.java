package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Display.Menus.HomeMenu;
import fr.sedara.Pusher.Game;

import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class TaskDisplay implements Runnable {

    public static JFrame       frame;
    public static JPanelGame   gamePanel;
    public static JPanelEditor editorPanel;
    public static HomeMenu     home;
    public Game game;
    
    //TODO statics à enlever

    public void run() {
        frame = new JFrame();
        home = new HomeMenu();
        frame.setContentPane(home);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setEnabled(true);
        // TODO --> frame.addKeyListener(new KeyListener(game));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
