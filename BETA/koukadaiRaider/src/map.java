package src;

import java.util.Random;

public class map {
	public static Random random = new Random(); 
	public static rooms[][] roomArray = new rooms[5][5];
	
	public static int x = 2;
    public static int y = 0;
	
	public static void map() {
		//enemy 
		int d = 0;
		//loot
		int f = 10;
		//sword 
		int z = 2;
		//enmaku
		int c = 0;
		//Boss
		int b = 0;
		
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				roomArray[i][j] = new rooms(); //rooms
				roomArray[i][j].cont = inside(); //contents
				
				//possible exits
				for(int v = 0; v < 4; v++) {
					roomArray[i][j].exit[v] = roomArray[i][j].dir[random.nextInt(5)];
					if(i == 0) {
						if(roomArray[i][j].exit[v] == "up") {
							roomArray[i][j].exit[v] = "none";
						}
					}
					if(j == 0) {
						if(roomArray[i][j].exit[v] == "left") {
							roomArray[i][j].exit[v] = "none";
						}
					}
					if(i == 4) {
						if(roomArray[i][j].exit[v] == "down") {
							roomArray[i][j].exit[v] = "none";
						}
					}
					if(j == 4) {
						if(roomArray[i][j].exit[v] == "right") {
							roomArray[i][j].exit[v] = "none";
						}
					}
					
					// check
					int cont = 0;
					if (roomArray[i][j].exit[v] == "none") {
						cont++;
					}
					
					if (cont >=1) {
						v = 0;
					}
				}
				
				
				if (i == y & j == x) {//checks
					roomArray[i][j].cont = "Player";
					roomArray[i][j].enmaku = 1;
                    //System.out.print(" PLAYER ");
                    continue;
				}
				
				if (roomArray[i][j].cont.equals("enemy") && (d != 2)){
					roomArray[i][j].enemy = 1;
					//System.out.print(" "+roomArray[i][j].cont+ " ");
					d++;
				} else if (roomArray[i][j].cont.equals("Loot")&& (f >= 0)) {
					roomArray[i][j].takara = random.nextInt(4) + 1;
					//System.out.print(" Loot:"+roomArray[i][j].takara);
					f--;
				} else if (roomArray[i][j].cont.equals("enmaku")&& (c != 4)) {
					roomArray[i][j].enmaku = 1;
					//System.out.print( " enmaku ");
					c++;
				} else if (roomArray[i][j].cont.equals("sword") && (z != 3)) {
					roomArray[i][j].sword = 1;
					//System.out.print(" sword ");
					z++;
				} else if (roomArray[i][j].cont.equals("enemy") && (d >= 2) && (b != 1)) {
					roomArray[i][j].boss = 1;
					//System.out.print(" BOSS ");
					b++;
				} else {
					roomArray[i][j].cont = "Empty";
					//System.out.print(" Empty ");
				}
			}
			//System.out.println("");
		}
		
	} 

	public static String inside() {
		String contents = null;
		Random random = new Random(); 
		int name;
		
		name = random.nextInt(4) + 1;
		if (name == 1) {
			contents = "Loot";
		} else if (name == 2) {
			contents = "enemy";
		} else if (name == 3) {
			contents = "enmaku";
		} else if (name == 4) {
			contents = "sword";
		} else {
			contents = "Empty";
		}
		
		return contents;
	}

}