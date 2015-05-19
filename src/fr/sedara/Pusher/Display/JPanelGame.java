package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Champs;

import javax.swing.JPanel;

import java.awt.GridLayout;

public class JPanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabelCase[][] tableau;
    private Champs         champs;


    public JPanelGame(Champs champs, TaskDisplay taskDisplay) {
        this.champs = champs;
        setLayout(new GridLayout(champs.getY(), champs.getX()));
        tableau = new JLabelCase[champs.getX()][champs.getY()];
        for (int i = 0; i < champs.getY(); i++) {
            for (int j = 0; j < champs.getX(); j++) {
                tableau[j][i] = new JLabelCase(champs.getCase(j, i), false, taskDisplay);
                add(tableau[j][i]);
            }
        }
        
        
    }


    public void setColor() {
        for (int i = 0; i < champs.getX(); i++) {
            for (int j = 0; j < champs.getY(); j++) {
                tableau[i][j].setColor();
            }
        }
    }

    public Champs getChamps() {
        return champs;
    }

}
