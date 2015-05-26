package fr.sedara.pusher.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.sedara.pusher.controller.LevelFileManager;

public class JOptionPaneOverwriteLevel extends JOptionPane{

	private static final long serialVersionUID = 1L;

	public JOptionPaneOverwriteLevel(JFrame frame, String fileName, TaskDisplay taskDisplay) {
		frame.setEnabled(false);
		final JOptionPane jo = new JOptionPane(taskDisplay.getController().getString("erase"), JOptionPane.WARNING_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		final JDialog jd = new JDialog(frame,taskDisplay.getController().getString("warning"),true);
		jd.setContentPane(jo);
		jd.setLocationRelativeTo(null);
		jd.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);


		jo.addPropertyChangeListener(
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						String prop = e.getPropertyName();
						if (jd.isVisible() && (e.getSource() == jo)	&& (prop.equals(JOptionPane.VALUE_PROPERTY))) {
							jd.dispose();
						}
					}
				});
		jd.pack();
		jd.setVisible(true);
		jd.toFront();

		int value = ((Integer)jo.getValue()).intValue();		
		if (value == JOptionPane.OK_OPTION) {
			frame.dispose();
			frame.setState(JFrame.EXIT_ON_CLOSE);
            try {
                LevelFileManager.save(taskDisplay.editorPanel.getChamps(), fileName);
            }catch (IOException e1) {}
            taskDisplay.frame.toFront();
            taskDisplay.frame.setEnabled(true);
		}else if (value == JOptionPane.CANCEL_OPTION) {
			taskDisplay.frame.toFront();
			frame.setEnabled(true);
			frame.toFront();
			frame.revalidate();
		}
	}

}
