import java.util.List;
import java.util.ArrayList;

class ImList<T> {
    private final ArrayList<T> elems;

    ImList() {
        this.elems = new ArrayList<T>();
    }

    ImList(List<T> list) {
        this.elems = new ArrayList<T>(list);
    }

    ImList<T> add(T elem) {
        ImList<T> newList = new ImList<T>(this.elems);
        newList.elems.add(elem);
        return newList;
    }

    ImList<T> set(int index, T elem) {
        ImList<T> newList = new ImList<T>(this.elems);
        newList.elems.set(index, elem);
        return newList;
    }

    T get(int index) {
        return this.elems.get(index);
    }

    int size() {
        return this.elems.size();
    }

    public String toString() {
        return this.elems.toString();
    }
}
