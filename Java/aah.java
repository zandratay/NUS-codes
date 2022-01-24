import java.util.*;

public class aah {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		String JM = sc.nextLine();
		String required = sc.nextLine();

		if (JM.length() < required.length()) {
			System.out.println("no");
		} else {
			System.out.println("go");
		}
	}
}
