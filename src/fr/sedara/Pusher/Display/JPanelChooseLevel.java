package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonPlayLevel;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;
import java.io.File;

public class JPanelChooseLevel extends JPanel implements ListSelectionListener {

    private static final long serialVersionUID = 1L;
    private JScrollPane        scroll;
    private JList<String>      jl;
    private JButtonPlayLevel   play;

    public JPanelChooseLevel(TaskDisplay taskDisplay) {
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
        add(scroll);
        scroll.setPreferredSize(new Dimension(100, 300));
        JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        play = new JButtonPlayLevel(taskDisplay);
        jsp.add(play);
        JButtonCancel cancel = new JButtonCancel(true, taskDisplay);
        jsp.add(cancel);
        jsp.setDividerSize(0);
        add(jsp);
        taskDisplay.frame.setSize(400, 350);
        taskDisplay.frame.setLocationRelativeTo(null);
    }

    public void valueChanged(ListSelectionEvent e) {
        play.setFileName(jl.getSelectedValue());
    }

}
