package src;

import java.util.Scanner;

public class move {
	Scanner USERINPUT = new Scanner(System.in);
	public int theHP; 
	public int flag;
	public int positionX;
	public int positionY;
	
	public void moving() {
		theHP = koukadaiRaider.playerHP;
		map map1 = new map();
		
		boolean gameActive = true;
        Scanner in = new Scanner(System.in);
        int x = map.x;
        int y = map.y;
        while (gameActive) {
        		//map
            for (int i = 0; i < 5; i++) {// prints columns
                for (int j = 0; j < 5; j++) {//prints rows
                    if (i == y & j == x) {//checks
                        System.out.print("***D***\n*     *\n*     *\n*     *\n*     *\n*******\n");
                        System.out.print(x);
                        System.out.println(y);
                    } else if(y<0){
                        System.out.print("そっちにはいけないよ\n");
                        y++;
                    }else if(y>4){
                        System.out.print("そっちにはいけないよ\n");
                        y--;
                    }else if(x<0){
                        System.out.print("そっちにはいけないよ\n");
                        x++;
                    }else if(x>4){
                        System.out.print("そっちにはいけないよ\n");
                        x--;
                    }
                }
            }
                if (x == 2 && y == 0) {
                	System.out.println("You are at the start");
                	System.out.println("");
                }
                
                if (x == 4 && y == 0) {
                	System.out.println("BOSS");
                }
                
                if (x == 1 && y == 4) {
                	System.out.println("You got a Sword");
                }

                System.out.println("Enter 1 to quit");
                System.out.println("Enter u,d,l,r");
                String move = in.next();
                if (move.equals("1")) { //quits 
                        gameActive = false;
                        break;
                }
                if (move.equals("u")) { //movement commands
                    y--;
                } else if (move.equals("d")) {
                    y++;
                } else if (move.equals("l")) {
                	x--;
                } else if (move.equals("r")) {
                    x++;
                } else {
                	System.out.println("");
                	System.out.println("ERROR");
                }

        }
        
		/*
		int positionX = 0;
		int positionY = 0;
		map map1 = new map();
		if (positionX == 0 && positionY == 0) {
			System.out.println("Start");
			System.out.println("Write u to go north");
			direction = USERINPUT.nextLine();
			if(direction.equals("u")) {
				System.out.println("north");
				battle bat = new battle();
				bat.fight();
				theHP = bat.hp;
			} else if(direction.equals("s")) {
				System.out.println("yes");
				flag();
				return;
			} else {
				return;
			}		
		}
		*/
	}
	public void flag() {
		flag = 1;
		return;
	}

}
