import com.sun.media.jfxmedia.events.PlayerStateEvent;

import java.util.Scanner;

public class lol {
	public static final Scanner USERINPUT = new Scanner(System.in);
	
    public static void main(String[] args) {
        mainMenu();
        //Map map = new Map();
        //Move mv = new Move();
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------");
        System.out.println("       MAIN MENU       ");
        System.out.println("-----------------------");
        System.out.println("Welcome!");
        System.out.println();
        System.out.println(" 1.     New Game        ");
        System.out.println(" 2.     Rule        ");
        System.out.println(" 3.     Exit        ");
        System.out.println();
        System.out.print(" Make a Selection: ");
        System.out.println();
        System.out.println();
    }
    
    public static void newGame() {
    	//newGame
    	//boolean status = false;
    	System.out.println("GAME");
    }
    public static void rule() {
    	//rule
    	//boolean status = false;
    	System.out.println("RULES: ");
    	System.out.println("1) This is a game ");
    	System.out.println("2) bla bla bla");
    	System.out.println("3) bla bla");
    	System.out.println("Input any key for Main Menu");
        USERINPUT.nextLine();
        mainMenu();
    }
    public class player {
        int PlayerHP, PlayerStealth, Weapon, Smoke, Treasure;
    }
}







