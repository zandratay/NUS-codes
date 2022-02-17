// note did not pass all test cases on kattis (does not work for vv large input sizes), but does work for smaller inout sizes
// join strings
import java.util.*;
import java.io.*;

public class join {

	public static void main(String[] args) throws Exception {

		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] words = new String[n]; 
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		// pw.println(Arrays.toString(words));


		if (n == 1) {
			pw.print(words[0]);
		}

		else {
			String[] positions = new String[n];
			for (int b = 0; b < n; b++) {
				positions[b] = "";
			}

			for (int j = 0; j < n - 1; j++) {
				StringTokenizer FS = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(FS.nextToken());
				int b = Integer.parseInt(FS.nextToken());

				StringBuilder sb1 = new StringBuilder("");

				sb1.append(words[a - 1]);
				sb1.append(words[b - 1]);
				words[a - 1] = sb1.toString(); // positions instead of words
				// words[a - 1] = sb1.toString();
				//words[b - 1] = "";
				// pw.println(Arrays.toString(positions));
			}

			int maxLength = 0;
			String maxElem = words[0]; // same here
			for (int a = 0; a < n; a++) {
				if (words[a].length() >= maxLength) { //
					maxLength = words[a].length(); //
					maxElem = words[a];//
				} else {
					continue;
				}
			} 
			pw.print(maxElem);
			
		}
		pw.flush();
	}
}
