/**
 * Created by takumi on 2018/11/02.
 */
import java.util.*;

public class Move extends player {

	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();

	switch(str){
		case s:
			System.out.print(レーダーを使った！);
			return ++x, --x, ++y, --y;
			break;
		case u: 
			return x, --y;
			break;
		case r:
			return ++x, y;
			break;
		case l:
			return --x, y;
			break;
		case d:
			return x, ++y;
			break;
	}
	
	public boolean isCorrectIn(String input){
        String[] sp = input.split("");
        if(sp.length == 1 && (sp[0].equals("u") || sp[0].equals("d") || sp[0].equals("r") || sp[0].equals("l") || sp[0].equals("s"))){
            return true;
        }
        System.out.println("正しいキーを入力して下さい");
        return false;
	}
	
}
