package battleTest;
/*
* メインプログラマ：c0116337 ダニエルカデール
* 値調整：c0116297　渡邊 匠
* 他の班員は前回のメイン関数、マップ、移動のソースを書いていました。
* */
import java.util.Scanner;
import java.util.Random;

public class main {
	public static final Scanner USERINPUT = new Scanner(System.in);

	static int attackNum;
	static int PlayerHP = 150;
	static int EnemyHP = 500;
	static int sword = 0;
	static int count = 0;
	static double score;
	static double enemyAT = 1.15;
	static double weponAT = 1.3;
	static double dualweapon = 1.5;

	public static void main(String[] args) throws InterruptedException {
		System.out.println(PlayerHP);
		battle();
	}

	public static void battle() throws InterruptedException {
		System.out.println("武器の本数を選択してください。");//Select Sword
		System.out.println("0,  1,  2");
		String selection = USERINPUT.nextLine();
		switch (selection) {
			case "0":
				sword = 1;
				break;
			case "1":
				sword = 2;
				break;
			case "2":
				sword = 3;
				break;
			default:
				System.exit(0);
		}
		int i = 0;
		while (i < 1000) {
			i++;
			PlayerHP = 150;
			EnemyHP = 200;
			System.out.println(i+"回目の戦闘");

			while (PlayerHP != 0) {
				// System.out.println("エンターキーで攻撃開始");//Press Enter to attack
				//	USERINPUT.nextLine();

				diceroll();
				if (sword == 2) {
					System.out.println("攻撃力増加！");//Sword makes double damage
					attackNum = (int) ((double)attackNum * weponAT);
				} else if (sword == 3) {
					System.out.println("攻撃力更に増加！");//Sword makes triple damage
					attackNum = (int) ((double)attackNum * dualweapon);
				} else {
					attackNum = attackNum * 1;
				}

				System.out.println(attackNum + " ダメージ！");//DAMAGE
				EnemyHP = EnemyHP - attackNum;
				if (EnemyHP <= 0) {
					System.out.println("敵のHP:0");//Enemy HP is
					System.out.println("敵を倒した！");//He is dead
				} else {
					System.out.println("敵のHP:" + EnemyHP);//EnemyHP is
				}
				// Thread.sleep(1000);

				if (EnemyHP <= 0) {
					System.out.println("");
					System.out.println("戦闘に勝利！");//WIN
					count += 1;

					break;
				} else {
					System.out.println("敵の反撃！");//EnemyHP counter attack
					diceroll();
					System.out.println(attackNum + " ダメージ！");//DAMAGE
					PlayerHP = (int) ((double)PlayerHP - attackNum*enemyAT);

					if (PlayerHP <= 0) {
						System.out.println("プレイヤーのHP:0");//Your HP is
						System.out.println("ゲームオーバー");//Game over
						break;

					} else {
						System.out.println("プレイヤーのHP:" + PlayerHP);//Your HP is
					}

				}
				System.out.println("");

				continue;
			}
			System.out.println(count+"回勝利");
			score = (double)count/i*100;
			System.out.println("勝率："+score+"%");

		}
	}
	public static void diceroll() {
		Random random = new Random();
		attackNum = random.nextInt(50)+50 + 1;
	}

}
