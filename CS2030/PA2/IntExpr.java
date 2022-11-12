import java.util.stream.IntStream;

class IntExpr extends AbstractIntExpr {
    //private static final Operator<Integer> sub = Operator.<Integer>of((x, y) -> x - y, prec: 4);
    //private static final Operator<Integer> div = Operator.<Integer>of((x, y) -> x / y, prec: 3);

    private static final Operator<Integer> exp =
        Operator.of((x, y) -> {
            int temp = 1;
            for (int i = 0; i < y; i++) {
                temp = temp * x;
            }
            return temp;
        }, 2);

    IntExpr(Expr<Integer> expr) {
        super(expr);
    }
    
    /*
    public Integer getIntValue() {
        return this.getT();
    }
    */

    static IntExpr of(Integer value) {
        IntExpr exp = new IntExpr(Expr.<Integer>of(value));
        return exp;
    }

    IntExpr add(Integer value) {
        IntExpr exp = new IntExpr(Expr.<Integer>of(value));
        //return addition.apply(this, exp);
        return new IntExpr(super.op(addition, value));
    }

    IntExpr mul(Integer value) {
        Expr<Integer> exp = new IntExpr(Expr.<Integer>of(value));
        //return multiplication.apply(this, exp);
        return new IntExpr(super.op(multiplication, value));
    }

    private static final Operator<Integer> sub = 
        Operator.<Integer>of((x, y) -> x - y, 4);

    private static final Operator<Integer> div = 
        Operator.<Integer>of((x, y) -> x / y, 3);

    IntExpr sub(Integer value) {
        return new IntExpr(super.op(sub, value));
    }

    IntExpr div(Integer value) {
        return new IntExpr(super.op(div, value));
    }
    
    IntExpr exp(Integer value) {
        return new IntExpr(super.op(exp, value));
    }

    IntExpr add(IntExpr x) {
        return new IntExpr(super.op(addition, x));
    }

    IntExpr mul(IntExpr x) {
        return new IntExpr(super.op(multiplication, x));
    }

    IntExpr sub(IntExpr x) {
        return new IntExpr(super.op(sub, x));
    }

    IntExpr div(IntExpr x) {
        return new IntExpr(super.op(div, x));
    }

    IntExpr exp(IntExpr x) {
        return new IntExpr(super.op(exp, x));
    }

    //protected static final Operator<Integer> exp = 
        //Operator.<Integer>of((x, y) -> Math.pow(x, y), 2);
}
