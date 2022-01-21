import java.util.*;

public class Autori {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();

		String start = name.substring(0, 1);

		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i) == '-') {
				start += name.substring(i + 1, i + 2);
			}
		}
		System.out.println(start);
	}
}
