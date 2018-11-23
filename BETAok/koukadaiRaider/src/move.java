package src;

import java.util.Random;
import java.util.Scanner;

public class move {
	Scanner USERINPUT = new Scanner(System.in);
	public static int theHP; 
	public static int smoke; 
	public static int flag;
	public int positionX;
	public int positionY;
	
	@SuppressWarnings("static-access")
	public void moving() throws InterruptedException {
		theHP = koukadaiRaider.playerHP;
		battle bat1 = new battle();
		Random random = new Random();

		boolean gameActive = true;
        Scanner in = new Scanner(System.in);
        
        int x = map.x;
        int y = map.y;
        map map1 = new map();
        map1.map();
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
            
           //Player
           if (map1.roomArray[y][x].cont == "Player") {
           		if (flag == 0) {
           			System.out.println("");
           			System.out.println("You are at the start");
               		System.out.println("");
           		} else {
           			System.out.println("Exit");
           			koukadaiRaider.winCondition();
           		}
           }
            
           //Battle 
           if (map1.roomArray[y][x].cont == "enemy") {
        	   if(koukadaiRaider.enemyHP <= 0) {
        		   System.out.println("");
        		   System.out.println("Enemy is dead");
        		   System.out.println("");
        	   } else {
        	   if (koukadaiRaider.smoke == 0) {
        		   System.out.println("");
 				   System.out.println("You have no smokes");
  				   System.out.println("Prepare to fight");
  				   if (bat1.EnemyHP >= 0) {
  					   System.out.println("");
                	   System.out.println("ENEMY");
                	   bat1.battle();
  				   } else {
                		   System.out.println("");
                		   System.out.println("Enemy is dead");
                		   System.out.println("");
                   }
        	   } else 
        	   if (koukadaiRaider.smoke >= 0) {
        		   System.out.println("");
        		   System.out.println("Enemy in the room");
        		   System.out.println("Use smoke? (y/n)");
        		   String sm = in.next();
        		   if (sm.equals("y")) {
        			   	int stealth = 0;
        				if (koukadaiRaider.smoke != 0) {
        					stealth = random.nextInt(4)+5;
        					if (map1.roomArray[y][x].status <= stealth) {
        						System.out.println("Room stealth status is: "+map1.roomArray[y][x].status);
            					System.out.println("Your stealth status is: "+ stealth);
        						koukadaiRaider.smoke--;
        						System.out.println("Smoke left: "+koukadaiRaider.smoke);
        						System.out.println("You escaped");
            					System.out.println("");
            				} else {
            					System.out.println("Your Status is visible");
            					System.out.println("You have to fight");
            					if (bat1.EnemyHP >= 0) {
            						System.out.println("");
                         		    System.out.println("ENEMY");
                         		    bat1.battle();
                         	   } else {
                         		    System.out.println("");
                         		    System.out.println("Enemy is dead");
                         		    System.out.println("");
                         	   }
            				}
        				}        				
        		   } else if (sm.equals("n")) {
        			   System.out.println("");
        			   System.out.println("Prepare to fight");
        			   if (bat1.EnemyHP >= 0) {
        				   System.out.println("");
                		   System.out.println("ENEMY");
                		   bat1.battle();
                	   } else {
                		   System.out.println("");
                		   System.out.println("Enemy is dead");
                		   System.out.println("");
                	   }
        		   }  else {
        			   System.out.println("Incorrect input");
        			   System.out.println("");
        			   continue;
        		   }
        	   }
          	   }
  
           }
           
           //boss
           if (map1.roomArray[y][x].cont == "boss") {
        	   if(koukadaiRaider.bossHP <= 0) {
        		   System.out.println("");
        		   System.out.println("The boss is dead");
        		   System.out.println("");
        	   } else {
	        	   if(koukadaiRaider.bossHP <= 0) {
	        		   System.out.println("");
	        		   System.out.println("The boss is dead");
	        		   System.out.println("");
	        		   break;
	        	   }
	        	   if (koukadaiRaider.smoke == 0) {
	 				   System.out.println("You have no smokes");
	  				   System.out.println("Prepare to fight the Boss");
	  				   if (bat1.bossHP >= 0) {
	  					   System.out.println("");
	                	   System.out.println("BOSS");
	                	   bat1.bossbattle();
	  				   } else {
	            		   System.out.println("");
	            		   System.out.println("The boss is dead");
	            		   System.out.println("");
	                   }
	        	   } else 
	        	   if (koukadaiRaider.smoke >= 0) {
	        		   System.out.println("");
	        		   System.out.println("Boss Room");
	        		   System.out.println("Use smoke? (y/n)");
	        		   String sm = in.next();
	        		   if (sm.equals("y")) {
	        			   	int stealth = 0;
	        				if (koukadaiRaider.smoke != 0) {
	        					stealth = random.nextInt(4)+5;
	        					if (map1.roomArray[y][x].status <= stealth) {
	        						System.out.println("Room stealth status is: "+map1.roomArray[y][x].status);
	            					System.out.println("Your stealth status is: "+ stealth);
	        						koukadaiRaider.smoke--;
	        						System.out.println("Smoke left: "+koukadaiRaider.smoke);
	        						koukadaiRaider.bossHP = 25;
	        						System.out.println("Boss HP is cut in half!");
	            					System.out.println("");
	            					bat1.bossbattle();
	            				} else {
	            					System.out.println("Your Status is too visible");
	            					System.out.println("You have to fight him normaly");
	            					if (bat1.bossHP >= 0) {
	            						System.out.println("");
	                         		    System.out.println("Boss");
	                         		    bat1.bossbattle();
	                         	   } else {
	                         		    System.out.println("");
	                         		    System.out.println("Boss is dead");
	                         		   System.out.println("");
	                         	   }
	            				}
	        				}
	        				
	        		   } else if (sm.equals("n")) {
	        			   System.out.println("Prepare to fight");
	        			   if (bat1.bossHP >= 0) {
	        				   System.out.println("");
	                		   System.out.println("BOSS");
	                		   bat1.bossbattle();
	                	   } else {
	                		   System.out.println("");
	                		   System.out.println("The Boss is dead");
	                		   System.out.println("");
	                	   }
	        		   }  else {
	        			   System.out.println("Incorrect input");
	        			   System.out.println("");
	        			   continue;
	        		   }
	          	   }
        	   }
           }
            
            if (map1.roomArray[y][x].cont == "sword") {
            	if (map1.roomArray[y][x].sword != 0) {
            		koukadaiRaider.playerWeapon = 2;
            		System.out.println("");
            		System.out.println("You got a Sword");
            		System.out.println("");
            		map1.roomArray[y][x].sword = 0;
            	} else {
            		System.out.println("");
            		System.out.println("There was a sword here");
            		System.out.println("");
            	}
            }
            
            if (map1.roomArray[y][x].cont == "Loot") {
            	if (map1.roomArray[y][x].takara != 0) {
            		System.out.println("");
	            	System.out.println("Treasure!");
	            	koukadaiRaider.takara += map1.roomArray[y][x].takara;
	            	map1.roomArray[y][x].takara = 0;
	            	System.out.println("You have: "+koukadaiRaider.takara+" Gold");
	            	System.out.println("");
            	} else {
            		System.out.println("There was treasure here");
            		System.out.println("");
            	}
            }
            
            if (map1.roomArray[y][x].cont == "enmaku") {
            	if (map1.roomArray[y][x].enmaku != 0) {
	            	System.out.println("Got Smoke");
	            	koukadaiRaider.smoke++;
	            	System.out.println("Smoke is: "+ koukadaiRaider.smoke);
	            	System.out.println("");
	            	map1.roomArray[y][x].enmaku = 0;
            	} else {
            		System.out.println("");
            		System.out.println("Room is Empty");
            		System.out.println("");
            	}
            }
           	
            if (map1.roomArray[y][x].cont == "Empty") {
            	System.out.println("");
            	System.out.println("Room is Empty");
            	System.out.println("");
            }
        
            
            //System.out.println("Enter 1 to quit");
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
	                        continue;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved Up");
	                    y--;
	                    moves = false;
	                } else {
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	//break;
	                	moves = false;
	                }
	            } else if (move.equals("d")) {
	            	ok = 0;
	            	for (int v = 0; v < 4; v++) {
	            		if(map1.roomArray[y][x].exit[v].equals("down")) {
	            			ok = 1;
	                        continue;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved Down");
	                    y++;
	                    moves = false;
	                } else {
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	//break;
	                	moves = false;
	                }
	            } else if (move.equals("l")) {
	            	ok = 0;
	            	for (int v = 0; v < 4; v++) {
	            		if(map1.roomArray[y][x].exit[v].equals("left")) {
	            			ok = 1;
	                        continue;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved left");
	                    x--;
	                    moves = false;
	                } else {
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	//break;
	                	moves = false;
	                }
	            } else if (move.equals("r")) {
	            	ok = 0;
	            	for (int v = 0; v < 4; v++) {
	            		if(map1.roomArray[y][x].exit[v].equals("right")) {
	            			ok = 1;
	                        continue;
	            		}
	            	}
	            	if(ok == 1) {
	                	System.out.println("Moved Right");
	                    x++;
	                    moves = false;
	                } else {
	                	System.out.println("Can't move that way");
	                	System.out.println("Try again");
	                	//break;
	                	moves = false;
	                }
	            } else if (move.equals("radar")) {  
	            		for(int d = 0; d < 5; d++) {
	            			for (int f = 0; f < 5; f++) {
	            				if (d == y & f == x) {//checks
	                                System.out.print(" PLAYER ");
	                                continue;
	            				} 	            				
	            				
	            				if (map1.roomArray[d][f].cont.equals("enemy")){
	            					System.out.print(" "+map1.roomArray[d][f].cont+ " ");
	            				} else if (map1.roomArray[d][f].cont.equals("Loot")) {
	            					System.out.print(" "+map1.roomArray[d][f].cont+ " ");
	            				} else if (map1.roomArray[d][f].cont.equals("enmaku")) {
	            					System.out.print( " enmaku ");
	            				} else if (map1.roomArray[d][f].cont.equals("sword")) {					
	            					System.out.print(" sword ");
	            				} else if (map1.roomArray[d][f].cont.equals("boss")) {
	            					System.out.print(" BOSS ");
	            				} else {
	            					System.out.print(" Empty ");
	            				}
	            			}
	            			System.out.println("");
	            		} 
	            		koukadaiRaider.radar--;
	            		moves = false;
	            } else {
	            	System.out.println("");
	            	System.out.println("ERROR, Invalid input");
	            	System.out.println("");
	            	//break;
	            	moves = false;
	            }
	            
            }
            System.out.println("------------------------");
        }
	}
	
	public static void flag() {
		flag = 1;
		return;
	}

}
