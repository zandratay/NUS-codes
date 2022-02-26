// teque question on Kattis. exceeded time limit for some test cases (suspected to be a large input size of many "push_middle"s
import java.util.*;
import java.io.*;
import java.lang.*;

public class teque3 {

	public static void main(String[] args) throws Exception {

		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> left = new LinkedList<Integer>();
		LinkedList<Integer> right = new LinkedList<Integer>();
		int leftSize = left.size();
		int rightSize = right.size();
		int totalSize = leftSize + rightSize;

		for (int i = 0; i < n; i++) {
			// String command = pw.getWord();
			// int num = pw.getInt();
			String[] line = br.readLine().split(" ");
			String command = line[0];
			int num = Integer.parseInt(line[1]);

			if (command.equals("push_back")) {
				right.addLast(num);
				rightSize += 1;
				totalSize += 1;
			} else if (command.equals("push_front")) {
				left.addFirst(num);
				leftSize += 1;
				totalSize += 1;
			} else if (command.equals("push_middle")) {
				int k = totalSize;
				if (k % 2 == 0) {
					k = k / 2;
				} else {
					k = k + 1;
					k = k / 2;
				}
				if (left.size() <= right.size()) {
					int backK = k - leftSize;
					right.add(backK, num);
					rightSize++;
					totalSize++;
				} else {
					left.add(k, num);
					leftSize++;
					totalSize++;
				}
			} else if (command.equals("get")) {
				if (num < left.size()) {
					pw.println(left.get(num));
				} else {
					pw.println(right.get(num - left.size()));
				}
				
			}
		}

		pw.flush();
	}
}
