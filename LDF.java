// last digit factorial
import java.util.*;

public class LDF {

	static int LDF(int n) {
		if (n == 0 || n == 1) {return 1;}
		else if (n == 2) {return 2;}
		else if (n == 3) {return 6;}
		else if (n == 4) {return 4;}
		else {return 0;}
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // no. of test cases

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			System.out.println(LDF(a));
		}

	}
}
