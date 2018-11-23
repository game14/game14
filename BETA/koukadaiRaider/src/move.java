package src;

import java.util.Scanner;

public class move {
	Scanner USERINPUT = new Scanner(System.in);
	public static int theHP; 
	public int flag;
	public int positionX;
	public int positionY;
	
	@SuppressWarnings("static-access")
	public void moving() throws InterruptedException {
		theHP = koukadaiRaider.playerHP;
		battle bat1 = new battle();

		boolean gameActive = true;
        Scanner in = new Scanner(System.in);
        
        int x = map.x;
        int y = map.y;
        map map1 = new map();
        map1.map();
        //map1.roomArray[0][0].contents(); //test
        
        while (gameActive) {
    		//map  
    	
    		System.out.println("");
    		System.out.println("PlayerHP is: "+ theHP);
    		System.out.println("Smoke is: "+ koukadaiRaider.smoke);
            for (int i = 0; i < 5; i++) {// prints columns
                    for (int j = 0; j < 5; j++) {//prints rows
                            if (i == y & j == x) {//checks
                                    System.out.print(" o  ");
                            } else {
                                    System.out.print("XXX ");
                            }
                    }
                    System.out.println("");
            }

            if (map1.roomArray[y][x].cont == "Player") {
            	System.out.println("You are at the start");
            	System.out.println("");
            }
            
           if (map1.roomArray[y][x].cont == "enemy") {
        	   if (koukadaiRaider.smoke != 0) {
        		   System.out.println("Enemy in the room");
        		   System.out.println("Use smoke? (y/n)");
        		   String sm = in.next();
        		   if (sm.equals("y")) {
        			   koukadaiRaider.smoke--;
        			   System.out.println("Escaped");
        		   } else if (sm.equals("n")) {
        			   if (bat1.EnemyHP >= 0) {
                		   System.out.println("ENEMY");
                		   bat1.battle();
                	   } else {
                		   System.out.println("");
                		   System.out.println("Enemy is dead");
                	   }
        		   } else {
        			   System.out.println("Incorrect input");
        			   continue;
        		   }
        	   }
  
           }
            
            if (map1.roomArray[y][x].cont == "sword") {
            	koukadaiRaider.playerWeapon = 2;
            	System.out.println("You got a Sword");
            	map1.roomArray[y][x].sword = 0;
            }
            
            if (map1.roomArray[y][x].cont == "Loot") {
            	System.out.println("LOOT");
            	System.out.println("");
            }
            
            if (map1.roomArray[y][x].cont == "enmaku") {
            	if (map1.roomArray[y][x].enmaku != 0) {
	            	System.out.println("Got Smoke");
	            	koukadaiRaider.smoke++;
	            	System.out.println("Smoke is: "+ koukadaiRaider.smoke);
	            	System.out.println("");
	            	map1.roomArray[y][x].enmaku = 0;
            	} else {
            		System.out.println("Room is Empty");
            	}
            }
            
            if (map1.roomArray[y][x].cont == "Empty") {
            	System.out.println("Room is Empty");
            	System.out.println("");
            }
        
            
            //System.out.println("Enter 1 to quit");
            //System.out.println("");
            System.out.println("Enter u,d,l,r (up, down, left, right)");
            System.out.println("Write radar to use");
            String move = in.next();
            
            System.out.println("------------------------");
            
            //Quits
            if (move.equals("1")) {  
                gameActive = false;
                break;
            }
            //movement commands
            boolean moves = true;
            while (moves) {
            	int ok = 0;
	            if (move.equals("u")) { 
	            	
	            	for (int v = 0; v < 4; v++) {
	            		if(map1.roomArray[y][x].exit[v].equals("up")) {
	            			ok = 1;
	                        break;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved Up");
	                    y--;
	                    moves = false;
	                } else {
	                	System.out.println("");
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	break;
	                }
	            } else if (move.equals("d")) {
	            	ok = 0;
	            	for (int v = 0; v < 4; v++) {
	            		if(map1.roomArray[y][x].exit[v].equals("down")) {
	            			ok = 1;
	                        break;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved Down");
	                    y++;
	                    moves = false;
	                } else {
	                	System.out.println("");
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	break;
	                }
	            } else if (move.equals("l")) {
	            	ok = 0;
	            	for (int v = 0; v < 4; v++) {
	            		if(map1.roomArray[y][x].exit[v].equals("left")) {
	            			ok = 1;
	                        break;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved left");
	                    x--;
	                    moves = false;
	                } else {
	                	System.out.println("");
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	break;
	                }
	            } else if (move.equals("r")) {
	            	ok = 0;
	            	for (int v = 0; v < 4; v++) {
	            		if(map1.roomArray[y][x].exit[v].equals("right")) {
	            			ok = 1;
	                        break;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved Right");
	                    x++;
	                    moves = false;
	                } else {
	                	System.out.println("");
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	break;
	                }
	            } else if (move.equals("radar")) {  
	                map1.map();
	            } else {
	            	System.out.println("");
	            	System.out.println("ERROR, Invalid input");
	            	System.out.println("");
	            	break;
	            }
	            
            }
            System.out.println("------------------------");
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
