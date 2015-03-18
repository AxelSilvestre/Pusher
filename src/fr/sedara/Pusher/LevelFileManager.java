package fr.sedara.Pusher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LevelFileManager{


	public static void save(Champs champs) throws IOException{
		 File folder = new File("Levels");
		 if(!folder.exists()){
			 folder.mkdir();
		 }
	     File file= new File("Levels//level.Plvl");
	         ObjectOutputStream out = 
	             new ObjectOutputStream(
	                new FileOutputStream(file));
	         out.writeObject(champs);
	         out.close(); 	  
	}
	
	public static Champs load() throws IOException, ClassNotFoundException{
		File file = new File("Levels//level.Plvl");
	       ObjectInputStream in = 
	             new ObjectInputStream(
	                new FileInputStream(file));
	       Object champs = in.readObject();
	       in.close();
	       return (Champs) champs;
	}


	
}
