package fr.sedara.pusher.view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.sedara.pusher.model.Board;
import fr.sedara.pusher.model.Type;

import java.awt.Dimension;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class JPanelEditor extends JSplitPane {

    private Board         board;
    private JLabelCase[][] tableau;
    private JChoosePanel   choosePanel;
    private Type           selectedType;

    public JPanelEditor(Board board, TaskDisplay taskDisplay) {
        super(JSplitPane.HORIZONTAL_SPLIT);
        this.board = board;
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(board.getY(), board.getX()));
        tableau = new JLabelCase[board.getX()][board.getY()];
        for (int i = 0; i < board.getY(); i++) {
            for (int j = 0; j < board.getX(); j++) {
                tableau[j][i] = new JLabelCase(board.getBox(j, i), true, taskDisplay);
                pan.add(tableau[j][i]);
            }
        }
        pan.setPreferredSize(new Dimension(board.getX() * 50, board.getY() * 50));
        setResizeWeight(0.1);
        choosePanel = new JChoosePanel(this, taskDisplay);
        add(choosePanel);
        add(pan);
        setDividerSize(0);
    }

    public Type getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(Type selectedType) {
        this.selectedType = selectedType;
    }

    public Board getBoard() {
        return board;
    }

	public boolean havePlayer() {
		if(board.getPlayer() != null)
			return true;
		return false;
	}

}
