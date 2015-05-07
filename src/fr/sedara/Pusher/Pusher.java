package fr.sedara.Pusher;

import fr.sedara.Pusher.Display.TaskDisplay;

import javax.swing.SwingUtilities;

public class Pusher {

    private static Champs champs;
    
    // TODO Champs directement sur TaskPlay et non ici

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TaskDisplay());
    }

    public static Champs getChamps() {
        return champs;
    }

    public static void setChamps(Champs champs) {
        Pusher.champs = champs;
    }

}
