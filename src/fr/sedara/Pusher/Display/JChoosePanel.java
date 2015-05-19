package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonOpenFile;
import fr.sedara.Pusher.Display.JButtons.JButtonValidateEdition;
import fr.sedara.Pusher.Type;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

@SuppressWarnings("serial")
public class JChoosePanel extends JPanel {

    private JPanelEditor editor;
    private JLabel warning;

    public JChoosePanel(JPanelEditor editor, TaskDisplay taskDisplay) {
        this.editor = editor;
        JLabelChoose jl;
        JLabel name;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.weightx = 2;
        gbc.weighty = Type.NUMBER_OF_BLOCKS + 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JButtonOpenFile(taskDisplay), gbc);
        gbc.gridx = 1;
        warning = new JLabel();
        add(warning, gbc);
        for (int i = 0; i < Type.NUMBER_OF_BLOCKS; i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            jl = new JLabelChoose(Type.getType(i), this);
            name = new JLabel(jl.getType().getName());
            add(name, gbc);
            gbc.gridx = 1;
            add(jl, gbc);

        }
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JButtonValidateEdition(taskDisplay), gbc);
        gbc.gridx = 1;
        add(new JButtonCancel(true, taskDisplay), gbc);


    }
    
    public boolean exisitingPlayer(){    	
    	if(editor.havePlayer())
    		return true;    	
    	return false;
    }

    public void setSelectedType(Type selectedType) {
        editor.setSelectedType(selectedType);
    }
    
    public void setWarning(String text){
    	warning.setText(text);
    }


}
