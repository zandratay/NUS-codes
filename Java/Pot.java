import java.util.*;
import java.util.Scanner.*;

public class pot {

	static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of test cases
		
		for (int i = 0; i < n; i++) {
			String s = sc.next(); // next() method finds and returns the next complete token from this scanner. A complete token is preceded and followed by input that matches the delimiter pattern. 
			int base = Integer.parseInt(s.substring(0, s.length() - 1)); // The method generally used to convert String to Integer in Java is parseInt(). This method belongs to Integer class in java. lang package. It takes a valid string as a parameter and parses it into primitive data type int
			int pow = Integer.parseInt(s.substring(s.length() - 1, s.length()));
			sum += (int)Math.pow(base, pow);
		}
		
		System.out.println(sum);
	}
}
