package fr.sedara.Pusher;

public class LevelGenerator {
	
	public static void generateLevel(Champs champs){
		champs.getCase(0, 1).setType(Type.PLAYER);
		champs.getCase(0, 0).setType(Type.WALL);
		champs.getCase(0, 10).setType(Type.WALL);
		champs.getCase(10, 9).setType(Type.WALL);
		
	}

}
