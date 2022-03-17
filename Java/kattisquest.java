import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class kattisquest {
	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	long n = Integer.parseInt(br.readLine());
    	TreeMap<Integer, PriorityQueue<Long>> store = new TreeMap<Integer, PriorityQueue<Long>>();
    	
    	for (int i = 0; i < n; i++) {
    		String[] line = br.readLine().split(" ");
    		String cmd = line[0];

    		if (cmd.equals("add")) {
    			int E = Integer.parseInt(line[1]);
    			long G = Integer.parseInt(line[2]);

    			if (!store.containsKey(E)) {
    				PriorityQueue<Long> pq = new PriorityQueue<Long>(Comparator.reverseOrder());
    				pq.add(G);
    				store.put(E, pq);
    			} else {
    				store.get(E).add(G);
    			}

    		} else if (cmd.equals("query")) {
    			int energy = Integer.parseInt(line[1]);
    			long total = 0;
    			while (energy > 0) {
    				Integer highestEnergy = store.floorKey(energy);
    				if (highestEnergy == null) {
    					break;
    				} else {
    					total += store.get(highestEnergy).poll();
    				}
    				
    				if (store.get(highestEnergy).isEmpty()) {
    					store.remove(highestEnergy);
    				}
    				energy -= highestEnergy;
    			}
    			pw.println(total);
    		}
    	}

    	pw.flush();
	}
}
