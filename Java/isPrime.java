import java.util.*;

public class isPrime {

	public static boolean isPrime(int num) {
		boolean checker = true;
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				checker = false; // is not prime, divisible by other numbers;
				break;
			} else {
				continue;
			}
		}
		return checker;
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // num of test cases

		for (int j = 0; j < n; j++) {
			int a = sc.nextInt();
			if (isPrime(a)) {
				System.out.println("Prime number");
				continue;
			} else {
				System.out.println("Not prime");
			}
		}
	}
}
