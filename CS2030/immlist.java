import java.util.*;

class Imlist<T> {
    private final ArrayList<T> elems;
    // constructor for empty imlist
    Imlist() {
        this.elems = new ArrayList<T>();
    }
    // constructor of imlist which contains elements
    Imlist(List<T> elems) {
        this.elems = new ArrayList<T>(elems);
    }
    @Override
    public String toString() {
        return this.elems.toString();
    }
    int size() { // parametric polymorphism -- methods defined similarly
        return this.elems.size();
    }
    Imlist<T> add(T elem) { // elem added to list is of reference type Integer. not int
        Imlist<T> newList = new Imlist<T>(this.elems); // original list
        newList.elems.add(elem); // same add method as per List interface. dooesn't actually work, but compiles
        return newList;
    }
    public T get(int index) {
        return this.elems.get(index);
    }
}

class Point {
    private final Imlist<Integer> coord;
    Point(Integer x, Integer y) {
        this.coord = new Imlist<Integer>(List.of(x, y));
    }
    private Integer getX() {
        return this.coord.get(0);
    }
    private Integer getY() {
        return this.coord.get(1);
    }
    Point moveBy(Integer x, Integer y) {
        return new Point(this.getX() + x, this.getY() + y);
    }
    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
}

public class immlist {
    public static void main(String[] args) {
        Imlist list1 = new Imlist();
        System.out.println(list1.toString());
        
        Imlist list2 = new Imlist(List.of(1, 2, 3));
        System.out.println(list2.toString());

        list2.add(4);
        System.out.println(list2.toString());
        System.out.println(list2.size());
        // System.out.println(list2.get(1));

        Point p1 = new Point(1, 2);
        System.out.println(p1.moveBy(1, 2).toString());
        
    }
}
