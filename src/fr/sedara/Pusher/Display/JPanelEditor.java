package fr.sedara.Pusher.Display;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.sedara.Pusher.Champs;
import fr.sedara.Pusher.Type;

@SuppressWarnings("serial")
public class JPanelEditor extends JSplitPane{

	private Champs champs;
	private JLabelCase[][] tableau;
	private JChoosePanel choosePanel;
	private Type selectedType;
	
	public JPanelEditor(Champs champs) {
		super(JSplitPane.HORIZONTAL_SPLIT);
		this.champs = champs;
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(champs.getY(), champs.getX()));
		tableau = new JLabelCase[champs.getX()][champs.getY()];
		for(int i=0;i<champs.getY();i++){
			for(int j=0;j<champs.getX();j++){
				tableau[j][i] = new JLabelCase(champs.getCase(j, i), true);
				pan.add(tableau[j][i]);
			}
		}
		
		choosePanel = new JChoosePanel(this);
		add(choosePanel);
		add(pan);
	}

	public Type getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(Type selectedType) {
		this.selectedType = selectedType;
	}
	
	
	
	
	
	
}
