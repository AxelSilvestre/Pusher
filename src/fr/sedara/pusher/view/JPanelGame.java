package fr.sedara.pusher.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.sedara.pusher.model.Board;

public class JPanelGame extends JSplitPane {

	private static final long serialVersionUID = 1L;
	
	private JLabelCase[][] tableau;
    private Board         board;


    public JPanelGame(Board board, TaskDisplay taskDisplay) {
    	super(JSplitPane.VERTICAL_SPLIT);
    	JPanel game = new JPanel();
        this.board = board;
        game.setLayout(new GridLayout(board.getY(), board.getX()));
        tableau = new JLabelCase[board.getX()][board.getY()];
        for (int i = 0; i < board.getY(); i++) {
            for (int j = 0; j < board.getX(); j++) {
                tableau[j][i] = new JLabelCase(board.getBox(j, i), false, taskDisplay);
                game.add(tableau[j][i]);
            }
        }
        
        JPanel j = new JPanel();
        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        JPanel j3 = new JPanel();
        
        JLabel ja = new JLabel("Move");
        JLabel jsb = new JLabel("Catch / Release");
        JLabel jp = new JLabel("Pause menu");
        
        ImageIcon ia = new ImageIcon("img/arrows.png");
        ImageIcon isb = new ImageIcon("img/spacebar.png");
        ImageIcon ip = new ImageIcon("img/escape.jpg");
        
        JLabel jai = new JLabel();
        jai.setIcon(ia);
        
        JLabel jsbi = new JLabel();
        jsbi.setIcon(isb);
        
        JLabel jpi = new JLabel();
        jpi.setIcon(ip);
        
        j1.add(jai);
        j1.add(ja);
        
        j2.add(jsbi);
        j2.add(jsb);
        
        j3.add(jpi);
        j3.add(jp);
        
        j.add(j1);
        j.add(j2);
        j.add(j3);
        
        setResizeWeight(0.99);
        add(game);
        add(j);
        setDividerSize(0);
        
    }


    public void setColor() {
        for (int i = 0; i < board.getX(); i++) {
            for (int j = 0; j < board.getY(); j++) {
                tableau[i][j].setColor();
            }
        }
    }

    public Board getChamps() {
        return board;
    }

}
