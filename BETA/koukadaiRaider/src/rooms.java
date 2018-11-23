package src;

public class rooms {
	public String cont;
	int enemy = 0;
	int enmaku = 0;
	int takara = 0;
	int sword = 0;
	int boss = 0;
	String[] dir = { "none", "left", "right", "up", "down"};
	String[] exit = new String[4];
	
	public void contents() {
		System.out.println(cont);
		System.out.println(enemy);
		System.out.println(enmaku);
		System.out.println(takara);
		System.out.println(sword);
		System.out.println(boss);
		System.out.println(exit[0]+" "+exit[1]+" "+exit[2]+" "+exit[3]);
		System.out.println("");
		return;
	}
}
