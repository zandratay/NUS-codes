import java.io.*;
import java.util.*;
import java.lang.*;

public class weakvertices {
	public static void main(String[] args) throws IOException {

		Kattio ki = new Kattio(System.in, System.out);

		int n; // can be part of a separate graph too

		while((n = ki.getInt()) != -1) {
			int[][] adjMatrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adjMatrix[i][j] = ki.getInt();
				}
			}

			int formsTriangleList[] = new int[n];
			// trying to see if triangle
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					} 
					for (int k = 0; k < n; k++) {
						if (i == k || j == k) {
							continue;
						}
						if (adjMatrix[i][j] == 1 && adjMatrix[i][k] == 1 && adjMatrix[j][k] == 1) {
							formsTriangleList[i] = 1;
							formsTriangleList[j] = 1;
							formsTriangleList[k] = 1;
						} // else if (i == -1) {
							// 
							//}
					}
				}
			}
			for (int x = 0; x < formsTriangleList.length; x++) {
				if (formsTriangleList[x] != 1) {
					System.out.print(x+ " ");
				}
			}
			System.out.println();
		}
		ki.close();
	}
}
