package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonDeleteLevel;
import fr.sedara.Pusher.Display.JButtons.JButtonOpenFile;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.File;

public class JFrameEditorChooseLevel extends JFrame implements ListSelectionListener {

    private static final long serialVersionUID = 1L;

    private JScrollPane     	scroll;
    private JList<String>   	jl;
    private JButtonOpenFile		open;
    private JButtonDeleteLevel 	delete;
    private	JButtonCancel		cancel;

    public JFrameEditorChooseLevel(TaskDisplay taskDisplay) {
        File folder = new File("Levels");
        String[] list = folder.list();
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        String toRemove = ".Plvl";
        for (String str : list) {
            if (str.endsWith(toRemove)) { dlm.addElement(str.replace(toRemove, "")); }
        }
        jl = new JList<String>(dlm);
        jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl.addListSelectionListener(this);
        scroll = new JScrollPane(jl);        
        JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane jsp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jsp.add(scroll);
        open   = new JButtonOpenFile(this, taskDisplay);
        delete = new JButtonDeleteLevel(this, taskDisplay);
        cancel = new JButtonCancel(this, taskDisplay);
        jsp3.add(delete);
        jsp3.add(cancel);
        jsp2.add(open);
        jsp2.add(jsp3);        
        jsp.add(jsp2);
        jsp3.setDividerSize(0);
        jsp2.setDividerSize(0);
        jsp.setDividerSize(0);
        add(jsp);
        setSize(100, 400);
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
        taskDisplay.frame.setEnabled(false);
        setLocationRelativeTo(null);
        setResizable(false);
        toFront();
    }

    public void valueChanged(ListSelectionEvent arg0) {
        open.setFileName(jl.getSelectedValue());
        delete.setFileName(jl.getSelectedValue());
    }

}
