package fr.sedara.Pusher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** The LevelFileManager allows you to manage your levels. Create, delete or load them.
 * The output folder will be named, if it doesn't exist, Levels.
 * @author Sedara
 *
 */
public class LevelFileManager {


    /** Saves a new level.
     * @param board : The board to save.
     * @param name : The name to give to it.
     * @throws IOException
     */
    public static void save(Board board, String name) throws IOException {
        File folder = new File("Levels");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File("Levels//" + name + ".Plvl");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(board);
        out.close();
    }

    /** Loads a level.
     * @param name : The name of the level to load.
     * @return The board of the level.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Board load(String name) throws IOException, ClassNotFoundException {
        File file = new File("Levels//" + name + ".Plvl");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object champs = in.readObject();
        in.close();
        return (Board) champs;
    }

    /** Deletes a level.
     * @param name : The name of the level to delete.
     */
    public static void delete(String name) {
        File file = new File("Levels//" + name + ".Plvl");
        file.delete();
    }


}
