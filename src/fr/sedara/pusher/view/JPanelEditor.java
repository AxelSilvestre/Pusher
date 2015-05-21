package fr.sedara.pusher.view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.sedara.pusher.model.Board;
import fr.sedara.pusher.model.Type;

import java.awt.Dimension;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class JPanelEditor extends JSplitPane {

    private Board         champs;
    private JLabelCase[][] tableau;
    private JChoosePanel   choosePanel;
    private Type           selectedType;

    public JPanelEditor(Board champs, TaskDisplay taskDisplay) {
        super(JSplitPane.HORIZONTAL_SPLIT);
        this.champs = champs;
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(champs.getY(), champs.getX()));
        tableau = new JLabelCase[champs.getX()][champs.getY()];
        for (int i = 0; i < champs.getY(); i++) {
            for (int j = 0; j < champs.getX(); j++) {
                tableau[j][i] = new JLabelCase(champs.getBox(j, i), true, taskDisplay);
                pan.add(tableau[j][i]);
            }
        }
        pan.setPreferredSize(new Dimension(champs.getX() * 50, champs.getY() * 50));
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

    public Board getChamps() {
        return champs;
    }

	public boolean havePlayer() {
		if(champs.getPlayer() != null)
			return true;
		return false;
	}

}
