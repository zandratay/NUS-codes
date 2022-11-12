import java.util.Optional;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.lang.Comparable;

class Operator<T> implements Comparable<Operator<T>> {
    private final int seed;
    private final BinaryOperator<T> bo;

    private Operator(BinaryOperator<T> bo, int seed) {
        this.bo = bo;
        this.seed = seed;
    }

    static <T> Operator<T> of(BinaryOperator<T> bo, int seed) {
        return new Operator<T>(bo, seed);
    }

    int getSeed() {
        return this.seed;
    }
    
    @Override
    public int compareTo(Operator<T> o) {
        return this.getSeed() - o.getSeed();
    }

    @Override 
    public String toString() {
        return "Operator of precedence " + this.getSeed();
    }

    T apply(T a, T b) {
        return bo.apply(a, b);
    }
}

// check why binaryop cannot be found
// check overriding and implementation of Comparable
