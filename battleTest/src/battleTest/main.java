package battleTest;

import java.util.Scanner;
import java.util.Random;

public class main {
	public static final Scanner USERINPUT = new Scanner(System.in);
	
	static int attackNum;
	static int PlayerHP = 15;
	static int EnemyHP = 15;
	static int sword = 0;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(PlayerHP);
		battle();
	}
	
	public static void battle() throws InterruptedException {
		System.out.println("Select Sword");
		System.out.println("1,  2,  or 3");
		String selection = USERINPUT.nextLine();
        switch (selection) {
            case "1":
                sword = 1;
                break;
            case "2":
                sword = 2;
                break;    
            case "3":
            	sword = 3;
            	break;
            default:
            	System.exit(0);
        }
		while(PlayerHP != 0) {
			System.out.println("Press Enter to attack");
			USERINPUT.nextLine();
			
			diceroll();
			if(sword == 2) {
				System.out.println("Sword makes double damage");
				attackNum = attackNum*2;
			} else if (sword == 3) {
				System.out.println("Sword makes triple damage");
				attackNum = attackNum*3;
			} else {
				attackNum = attackNum*1;
			}
					
			System.out.println(attackNum+ " DAMAGE");
			EnemyHP = EnemyHP-attackNum;
			if(EnemyHP <= 0) {
				System.out.println("EnemyHP is 0");
				System.out.println("He is dead");
			} else {
				System.out.println("EnemyHP is "+ EnemyHP);
			}
			Thread.sleep(1000);
			
			if (EnemyHP <= 0) {
				System.out.println("");
				System.out.println("WIN");
				break;
			} else {
				System.out.println("EnemyHP counter attack");
				diceroll();
				System.out.println(attackNum+ " DAMAGE");
				PlayerHP = PlayerHP-attackNum;
				
				if(PlayerHP <= 0) {
					System.out.println("Your HP is 0");
					System.out.println("Game Over");
				} else {
					System.out.println("PlayerHP is "+ PlayerHP);
				}
				
			}
			System.out.println("");
			
			continue;
		}
	}
	
	public static void diceroll() {
		Random random = new Random(); 
		attackNum = random.nextInt(6) + 1;
	}

}
