package src;


public class map {
	public int enemyhp;
	public int bosshp;
	public static int x = 2;
    public static int y = 0;
	
	public map() {
		bosshp = koukadaiRaider.bossHP;
		enemyhp = koukadaiRaider.enemyHP;
		
		String[][] mapz = new String[5][5];
		mapz[2][0] = "START";
		mapz[4][0] = "BOSS";
		mapz[1][4] = "SWORD";
 	}
    
}