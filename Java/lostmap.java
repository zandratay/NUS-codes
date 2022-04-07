// tay xinyu, zandra
// A0239429U
// lost map
// kattis 1 sec can support 10^8 ops per second
// javac lostmap.java
// java lostmap < tc1-lm.txt
// java lostmap < tc2-lm.txt

import java.util.*;
import java.io.*;
import java.lang.*;

public class lostmap {
    public static void main(String[] args) {
        Kattio ki = new Kattio(System.in, System.out);

        int n = ki.getInt();
        int[][] adjMat = new int[n][n];
        ArrayList<IntegerTriplet> edgeList = new ArrayList<IntegerTriplet>(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMat[i][j] = ki.getInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edgeList.add(new IntegerTriplet(i, j, adjMat[i][j]));
            }
        }

        Collections.sort(edgeList);

        StringBuilder sb = new StringBuilder();
        DisjointUnionSets UFDS = new DisjointUnionSets(n); // each village will be a disjoint set at the start
        for (IntegerTriplet edge : edgeList) {
            int vertex1 = edge.first();
            int vertex2 = edge.second();
            if (!UFDS.isSameSet(vertex1, vertex2)) {
                UFDS.union(vertex1, vertex2);
                // note: change to one-based indexing!!
                sb.append(vertex1 + 1).append(" ").append(vertex2 + 1).append("\n");
            }
        }
        System.out.print(sb);

        ki.flush();
    }
}

class DisjointUnionSets {
    public int[] parent;
    public int n; // number of sets
    public ArrayList<Long> setSum;
    public ArrayList<Integer>[] children;
    public ArrayList<Integer> setSize;
    public ArrayList<ArrayList<Integer>> sets;
    //HashMap<Integer, Integer> sets;

    public DisjointUnionSets(int n) {
        //this.rank = new int[n+1];
        this.parent = new int[n+1];
        this.children = new ArrayList[n+1];
        this.n = n;
        this.setSum = new ArrayList<>(n+1);
        this.sets = new ArrayList<ArrayList<Integer>>(n+1);
        this.setSize = new ArrayList<>(n+1);
        //this.sets = new HashMap<Integer, Integer>();
        makeSet();
    }

    // Creates n sets with single item in each
    public void makeSet() {
        for (int i = 0; i <= n; i++) { // includes n bcos set consists of integers 1 to n
            // integers from 1 to n
            parent[i] = i;
            children[i] = new ArrayList<>();
            children[i].add(i);
            setSize.add(1);
            setSum.add((long) i);
            sets.add(new ArrayList<Integer>()); // add an empty array to each position to signify a set
            sets.get(i).add(i);
        }
    }

    // Returns representative of the set that x is in
    // path alr compressed, so just return
    public int find(int x) { // O(1)
        return parent[x];
    }

    public boolean isSameSet(int x, int y) { // O(1)
        return parent[x] == parent[y];
    }

    // for function 1
    public void union(int x, int y) {
        // Find representatives of two sets
        int xRoot = find(x);
        int yRoot = find(y);

        if (!isSameSet(x, y)) { // not in same set
            
            if (setSize.get(yRoot) <= setSize.get(xRoot)) { // If x's rank is less than y's rank, move x under y. but in the case of my code, i'm using size of children to compare
                for (int i = 0; i < setSize.get(yRoot); i++) { // O(size) ?? :(
                    int move = (Integer) children[yRoot].get(i);
                    children[xRoot].add(move);
                    parent[move] = xRoot;
                    if (parent[i] == yRoot) {
                        parent[i] = xRoot;
                        sets.get(xRoot).add(i); 
                    }
                    //continue;
                }
                //children[yRoot].clear();
                sets.get(xRoot).add(yRoot); 
                setSize.set(xRoot, setSize.get(xRoot) + setSize.get(yRoot)); // modify size
                setSum.set(xRoot, setSum.get(xRoot) + setSum.get(yRoot)); // modify sum


            } else { // Else if y's rank is less than x's rank, move y under x
                for (int i = 0; i < setSize.get(xRoot); i++) { // O(size) ??
                    int move = (Integer) children[xRoot].get(i);
                    children[yRoot].add(move);
                    parent[move] = yRoot;
                    if (parent[i] == xRoot) {
                        parent[i] = yRoot;
                        sets.get(yRoot).add(i); 
                    }
                    //continue;
                }
                //children[xRoot].clear();
                sets.get(yRoot).add(xRoot); 
                setSize.set(yRoot, setSize.get(yRoot) + setSize.get(xRoot)); // modify size
                setSum.set(yRoot, setSum.get(yRoot) + setSum.get(xRoot)); // modify sum

            } 

        } else { // in same set
            return;
        }
    }
}

// some reference taken from https://www.geeksforgeeks.org/sort-an-array-of-triplet-using-java-comparable-and-comparator/
class IntegerTriplet implements Comparable<IntegerTriplet> {
    public Integer first, second, weight;

    public IntegerTriplet(Integer first, Integer second, Integer weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public int compareTo(IntegerTriplet a) {
        return this.weight() - a.weight();
    }

    public Integer first() {
        return first;
    }
    public Integer second() {
        return second;
    }
    public Integer weight() {
        return weight;
    }
}

/** Taken from https://github.com/Kattis/kattio/blob/master/Kattio.java
 * Simple yet moderately fast I/O routines.
 *
 * Example usage:
 *
 * Kattio io = new Kattio(System.in, System.out);
 *
 * while (io.hasMoreTokens()) {
 *    int n = io.getInt();
 *    double d = io.getDouble();
 *    double ans = d*n;
 *
 *    io.println("Answer: " + ans);
 * }
 *
 * io.close();
 *
 *
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 *   Kattio-instance, otherwise, you may lose output.
 *
 * - The getInt(), getDouble(), and getLong() methods will throw an
 *   exception if there is no more data in the input, so it is generally
 *   a good idea to use hasMoreTokens() to check for end-of-file.
 *
 * @author: Kattis
 */
class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    public String nextLine() throws IOException{
        return r.readLine();

    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }

}
