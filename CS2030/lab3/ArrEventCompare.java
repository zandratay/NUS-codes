import java.util.Comparator;

//private static final int TEN = 10;

class ArrEventCompare implements Comparator<Event> {
    private static final int ONE = 1;
    private static final int NEG_ONE = -1;

    public int compare(Event e1, Event e2) {
        Customer c1 = e1.getCust();
        Integer id1 = c1.getCustNum();
        Double t1 = e1.getTime();
        Integer o1 = e1.getOrder();
        //Integer diff1 = id1 - o1;

        Customer c2 = e2.getCust();
        Integer id2 = c2.getCustNum();
        Double t2 = e2.getTime();
        Integer o2 = e2.getOrder();
        //Integer diff2 = id2 - o1;

        if (t1 < t2) {
            return NEG_ONE;
        } else if (t1 > t2) {
            return ONE;
        } else {
            //return id1 - id2;
            if (id1.equals(id2)) {
                return o2 - o1;
            } else {
                return id1 - id2;
            }
        }
    }
}
