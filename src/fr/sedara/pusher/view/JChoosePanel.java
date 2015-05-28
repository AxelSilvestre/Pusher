package fr.sedara.pusher.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.sedara.pusher.model.Type;
import fr.sedara.pusher.view.buttons.JButtonCancel;
import fr.sedara.pusher.view.buttons.JButtonChangeSize;
import fr.sedara.pusher.view.buttons.JButtonOpenFile;
import fr.sedara.pusher.view.buttons.JButtonValidateEdition;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

@SuppressWarnings("serial")
public class JChoosePanel extends JPanel {

    private JPanelEditor editor;
    private JLabel warning;
    private JTextField widht;
    private JTextField height;

    public JChoosePanel(JPanelEditor editor, TaskDisplay taskDisplay) {
        this.editor = editor;
        JLabelChoose jl;
        JLabel name;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.weightx = 2;
        gbc.weighty = Type.NUMBER_OF_BLOCKS + 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JButtonOpenFile(taskDisplay), gbc);
        gbc.gridx = 1;
        warning = new JLabel();
        add(warning, gbc);        
        gbc.gridx = 0;
        gbc.gridy = 1;        
        JPanel jpwidth = new JPanel();
        JLabel jlwidth = new JLabel(taskDisplay.getController().getString("width"));
        widht = new JTextField();
        widht.setPreferredSize(new Dimension(20, 20));
        jpwidth.add(jlwidth);
        jpwidth.add(widht);
        add(jpwidth, gbc);
        gbc.gridx = 1;
        JPanel jpheight = new JPanel();
        JLabel jlheight = new JLabel(taskDisplay.getController().getString("height"));
        height = new JTextField();
        height.setPreferredSize(new Dimension(20, 20));
        jpheight.add(jlheight);
        jpheight.add(height);
        add(jpheight, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;   
        add(new JButtonChangeSize(taskDisplay, widht, height),gbc);
        for (int i = 0; i < Type.NUMBER_OF_BLOCKS; i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 3;
            jl = new JLabelChoose(Type.getType(i), this, taskDisplay);
            name = new JLabel(taskDisplay.getController().getString(jl.getType().getName()));
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
