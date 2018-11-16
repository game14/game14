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
		System.out.println("武器の本数を選択してください。");//Select Sword
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
			System.out.println("エンターキーで攻撃開始");//Press Enter to attack
			USERINPUT.nextLine();
			
			diceroll();
			if(sword == 2) {
				System.out.println("攻撃力2倍！");//Sword makes double damage
				attackNum = attackNum*2;
			} else if (sword == 3) {
				System.out.println("攻撃力3倍！");//Sword makes triple damage
				attackNum = attackNum*3;
			} else {
				attackNum = attackNum*1;
			}
					
			System.out.println(attackNum+ " ダメージ！");//DAMAGE
			EnemyHP = EnemyHP-attackNum;
			if(EnemyHP <= 0) {
				System.out.println("敵のHP:0");//Enemy HP is 
				System.out.println("敵を倒した！");//He is dead
			} else {
				System.out.println("敵のHP:"+ EnemyHP);//EnemyHP is 
			}
			Thread.sleep(1000);
			
			if (EnemyHP <= 0) {
				System.out.println("");
				System.out.println("戦闘に勝利！");//WIN
				break;
			} else {
				System.out.println("敵の反撃！");//EnemyHP counter attack
				diceroll();
				System.out.println(attackNum+ " ダメージ！");//DAMAGE
				PlayerHP = PlayerHP-attackNum;
				
				if(PlayerHP <= 0) {
					System.out.println("プレイヤーのHP:0");//Your HP is 
					System.out.println("ゲームオーバー");//Game over
				} else {
					System.out.println("プレイヤーのHP:"+ PlayerHP);//Your HP is
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
