import java.util.Comparator;

//private static final int TEN = 10;

class arrEventCompare implements Comparator<Event> {
    private static final int TEN = 10;

    public int compare(Event a1, Event a2) {
        Customer c1 = a1.getCust();
        //Event nextEventC1 = a1.nextEvent();
        Customer c2 = a2.getCust();
        //Event nextEventC2 = a2.nextEvent();

        if (c1.leaveTime() == c2.arrivalTime()) {
            return 1; // c1 done will always come before c2 arrive
        } else {
            //int timeofc1 = Math.ceil(c1.arrivalTime() * TEN);
            //int timeofc2 = Math.ceil(c2.arrivalTime() * TEN);
            //return timeofc2 - timeofc1; // c1 must come before c2
            return Double.compare(c1.arrivalTime(), c2.arrivalTime());
        }
    }
}
