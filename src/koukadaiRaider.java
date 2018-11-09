import com.sun.media.jfxmedia.events.PlayerStateEvent;

import java.util.Scanner;

public class koukadaiRaider {
	public static final Scanner USERINPUT = new Scanner(System.in);
	
    public static void main(String[] args) {
        mainMenu();
        //Battle bt = new Battle();
    }
    public static void mainMenu() {
    	welcome();
        boolean status = false;
        do {
            String selection = USERINPUT.nextLine();
            switch (selection) {
                case "1":
                    newGame();
                    status = true;
                    break;
                case "2":
                    rule();
                    status = true;
                    break;    
                case "3":
                    System.exit(0);
            }

        } while (status == false);
    }
    
    public static void welcome() {
        System.out.println("-----------------------");
        System.out.println("    KOUKADAI RAIDER    ");
        System.out.println("-----------------------");
        System.out.println("ようこそ!");
        System.out.println();
        System.out.println(" １）     NEW　GAME        ");
        System.out.println(" ２）     ゲームのルール        ");
        System.out.println(" ３）     EXIT        ");
        System.out.println();
        System.out.print(" 入力してください:  ");
        System.out.println();
        System.out.println();
    }
    
    public static void newGame() {
    	//Player x;
		//newGame
    	//boolean status = false;
        //Map map = new Map();
        //Move move = new Move();
    	//Player player1 = x.new Player(15);
    	System.out.println("GAME");
    }
    public static void rule() {
    	boolean status = false;
    	System.out.println("-----------------------");
        System.out.println("  　　　  ゲームのルール    ");
        System.out.println("-----------------------");
    	System.out.println("");
    	System.out.println("１）ゲームの目的");
    	System.out.println("２） ダンジョンの内容");
    	System.out.println("３）アイテム");
    	System.out.println("４）敵との戦闘");
    	System.out.println("５）ボス");
    	System.out.println("６）スコア");
    	System.out.println("７）Exit");
    	System.out.println("");
    	System.out.println("入力してください: ");
        do {
            String selection = USERINPUT.nextLine();
            switch (selection) {
                case "1":
                	System.out.println("プレイヤーの目的は敵をやり過ごしながらダンジョン内の宝を集め、脱出することである。\r\n" + 
                			"ダンジョンから脱出するにはダンジョンのどこかに潜むボスを倒して鍵を入手し、スタート地点に戻る必要がある。\r\n" + 
                			"ゲーム終了時に集めた宝の数とゲーム中のプレイヤーの行動によって「スコア」が算出される。\r\n" + 
                			"");
                    break;
                case "2":
                	System.out.println("ダンジョン内の部屋の数は、スタート地点とボス部屋を含めて「25」である。\r\n" + 
                            "ダンジョン内ではボスの他にも「敵」と遭遇することがある。\r\n" + 
                            "各部屋には「隠密性」というステータスが設定されており、道中で拾える「煙幕」があれば敵との戦闘を避けることができる。\r\n" + 
                  " 部屋ごとに進める方向が決まっている。一方通行になっていて前いた部屋に戻れなくなることもあるため注意。 \r\n" + 
      "原則、今いる部屋以外の情報は開示されない。しかしプレイヤーは制限付きで周囲4方向の部屋の情報を開示できる「レーダー」を使用することができる。  \r\n" + 
      " また、ダンジョン内では様々な「アイテム」を拾うことができる。 \r\n" + "");
                    break;
                case "3":
                	System.out.println("ダンジョン内では様々なアイテムがランダムに配置されている。拾えるアイテムは3種類ある。\r\n" + 
                			"「煙幕」\r\n" + 
                			"煙幕は一つ一つに個別に数値が設定されている。各部屋の「隠密性」の数値と所持している煙幕の数値の合計値が「10」を越えたとき、煙幕を消費して敵との戦闘から逃げ出すことができる。\r\n" + 
                			 " 「宝」\r\n" + 
                			"取れば取るほど、ゲーム終了時のスコアが加算されるアイテム。部屋によって１つしかなければ、3つ以上置かれていることも。ボス部屋でボスを倒せば、宝が５つ手に入る。\r\n" + 
                			" 「武器」\r\n"+
                			"取れば取るほど、プレイヤーの攻撃力が上がる。ダンジョン内に配置されている武器は2つである。\r\n"+ "");
                    break;
                case "4":
                	System.out.println("敵との戦闘は一定の乱数によってダメージを算出する1対1のコマンド式である。\r\n" + 
                			"プレイヤーの初期HPは「15」、道中の敵のHPは「15」、ボスのHPは、ボスのHPは「50」だが、条件を満たすとHPが「30」になる。\r\n" + 
                			"プレイヤーが「武器」を拾えば拾うほど、プレイヤーの攻撃力が上がる。\r\n" + 
                			"武器を所持していない状態での戦闘は危険である。\r\n" + 
                			"敵を倒した場合、敵はその部屋から消えるが、敵から逃げた場合は消えない。\r\n" + 
                			"敵との戦闘が成立した場合、宝が2個奪われる。\r\n" + 
                			"プレイヤーのHPが「0」になるとゲームが終了し、その時点のスコアが算出される。\r\n" + "");
                    break;
                case "5":
                	System.out.println("ボスの部屋には表口と裏口が設定されている。\r\n" + 
                			"プレイヤーが表口からは入れば、HP「50」のボスと戦闘になる。\r\n" + 
                			"プレイヤーが裏口からは入ってかつ煙幕を所持しているとHP「30」 のボスと戦闘になる。\r\n" + 
                			"ボスとの戦闘に勝利すると、鍵を入手する。この状態でスタート地点に戻ることでダンジョンから脱出でき、ゲームが終了し、スコアが算出される。\r\n" + "");
                    break;
                case "6":
                	System.out.println("ゲーム終了時にスコアが算出される。スコアの算出方法は以下の通りである\r\n" + 
                			"・プレイヤーが所持している宝の数×100点を加算\r\n" + 
                			"・ボス撃破ボーナスの500点を加算\r\n" + 
                			"・脱出ボーナスの200点を加算\r\n" + 
                			"・レーダーは3回以上使用した場合、使用回数×100点を減算\r\n" + "");
                    break;
                case "7":
                	status = true;
                	mainMenu();
                	System.exit(0);
            }
            System.out.println("Press Enter key");
            USERINPUT.nextLine();
            rule();
        } while (status == false);     
    }
    
    public class Player {
    	public int PlayerHP = 0;
    	public Player(int a) {
    		PlayerHP = a;
    	}
    }
}
