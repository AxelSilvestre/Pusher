package fr.sedara.Pusher.Display;

import java.awt.GridLayout;

import javax.swing.JPanel;

import fr.sedara.Pusher.Champs;

@SuppressWarnings("serial")
public class JPanelGame extends JPanel{
	
	private JLabelCase[][] tableau;
	private Champs champs;
	

	public JPanelGame(Champs champs) {
		this.champs = champs;
		setLayout(new GridLayout(champs.getY(), champs.getX()));
		tableau = new JLabelCase[champs.getX()][champs.getY()];
		for(int i=0;i<champs.getY();i++){
			for(int j=0;j<champs.getX();j++){
				tableau[j][i] = new JLabelCase(champs.getCase(j, i), false);
				add(tableau[j][i]);
			}
		}
	}
	

	public void setColor(){
		for(int i=0;i<champs.getX();i++){
			for(int j=0;j<champs.getY();j++){
				tableau[i][j].setColor();
			}
		}
	}
	
	public Champs getChamps(){
		return champs;
	}

}
