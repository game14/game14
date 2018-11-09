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
}
