import java.util.*;

public class takeTwoStones {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n % 2 == 1) {
			System.out.println("Alice");
		} else if (n % 2 == 0) {
			System.out.println("Bob");
		}
	}
}
