// pea and pancakes problem
import java.util.*;

public class peaPank {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean seenPea = false;
		boolean seenPancakes = false;

		int n = Integer.parseInt(sc.nextLine()); // num of restaurants

		for (int i = 0; i < n; i++) {

			int numItems = Integer.parseInt(sc.nextLine());
			String resName = sc.nextLine();

			for (int j = 0; j < numItems; j++) {
				
				String item = sc.nextLine();

				if (item.equals("pea soup")) {
					seenPea = true;
				}
				if (item.equals("pancakes")) {
					seenPancakes = true;
				}
			}
			if (seenPea == false || seenPancakes == false) {
				seenPancakes = false;
				seenPea = false;
				continue;

			} else if (seenPea == true && seenPancakes == true) {
				System.out.println(resName);
				break;
				
			}
		}
		if (seenPea == false || seenPancakes == false) {
			System.out.println("Anywhere is fine I guess");
		}
		
	}
}
