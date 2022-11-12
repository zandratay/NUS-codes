import java.util.function.Function;
//import java.lang.Comparable;
import java.util.function.Supplier;
import java.util.Optional;

class Expr<T> {
    private final Supplier<T> left;
    //protected final Expr<T> exp;
    private final Supplier<Optional<Expr<T>>> right;
    private final Optional<Operator<T>> operator;

    Expr(Supplier<T> left, Supplier<Optional<Expr<T>>> right, Optional<Operator<T>> operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    Expr(Expr<T> expr) {
        this.left = expr.left;
        this.right = expr.right;
        this.operator = expr.operator;
    }

    public Supplier<T> getLeft() {
        return this.left;
    }

    static <T> Expr<T> of(T t) {
        return new Expr<T>(() -> t, () -> Optional.empty(), Optional.empty());
    }
    
    @Override
    public String toString() {
        return "(" + this.evaluate() + ")";
    }

    Expr<T> op(Operator<T> oper, T t) {
        //Expr<T> newOther = Expr.<T>of(other);
        return op(oper, () -> Optional.of(Expr.of(t)));
    }

    Expr<T> op(Operator<T> oper, Expr<T> t) {
        return op(oper, () -> Optional.of(Expr.of(t.evaluate())));
    }

    Expr<T> op(Operator<T> oper, Supplier<Optional<Expr<T>>> t) {
        //return bo.apply(this, exp);
        return this.operator.map(x -> x.compareTo(oper) <= 0 ?
                new Expr<T>(() -> this.evaluate(),
                    t,
                    Optional.of(oper)) :
                new Expr<T>(left, 
                    () -> right.get().map(y -> y.op(oper, t)),
                    this.operator))
            .orElse(new Expr<T>(left, t, Optional.of(oper)));
    }

    T evaluate() {
        return this.operator.map(
                x -> x.apply(this.left.get(), this.right.get().map(y -> y.evaluate()).orElseThrow()))
            .orElseGet(this.left);
    }
    /*
    @Override
    int compareTo(T o) {
        return this.getT() - o.getT();
    }
    */
}
