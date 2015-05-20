package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Board;

import javax.swing.JPanel;

import java.awt.GridLayout;

public class JPanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabelCase[][] tableau;
    private Board         board;


    public JPanelGame(Board board, TaskDisplay taskDisplay) {
        this.board = board;
        setLayout(new GridLayout(board.getY(), board.getX()));
        tableau = new JLabelCase[board.getX()][board.getY()];
        for (int i = 0; i < board.getY(); i++) {
            for (int j = 0; j < board.getX(); j++) {
                tableau[j][i] = new JLabelCase(board.getBox(j, i), false, taskDisplay);
                add(tableau[j][i]);
            }
        }
        
        
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
