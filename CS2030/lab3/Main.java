import java.util.Scanner;

class Main {
    private static final int arriS = 4;
    private static final int servS = 3;
    private static final int leavS = 2;
    private static final int doneS = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();// name of server
        Server s1 = new Server(name, 0.0);
        PQ<Event> pq = new PQ<Event>(new ArrEventCompare());

        int counter = 1;
        int pqSize = 0;

        // priority scores
        //int arriS = 4;
        //int servS = 3;
        //int leavS = 2;
        //int doneS = 1;

        // miscellaneous magic nums
        int one = 1;
        int two = 2;

        while (sc.hasNextDouble()) {
            double arrivalTime = sc.nextDouble();
            double serviceTime = sc.nextDouble();
            Customer c1 = new Customer(arrivalTime, serviceTime, arrivalTime + serviceTime,
                          counter);
            // for lab 2: Event e = new Arrive(c1, s1);
            Arrive a1 = new Arrive(c1, s1, arrivalTime, arriS);

            pq = pq.add(a1);
            pqSize = pqSize + one;

            //System.out.println(a1);
            //System.out.println(a1.nextEvent());

            if (a1.nextEvent().equal(new Served(c1, s1, arrivalTime, servS))) {
                pq = pq.add(new Served(c1, s1, arrivalTime, servS));
                pq = pq.add(new Done(c1, s1, arrivalTime + serviceTime, doneS));
                pqSize = pqSize + two;
            } else if (a1.nextEvent().equal(new Leave(c1, s1, arrivalTime, leavS))) {
                pq = pq.add(new Leave(c1, s1, arrivalTime, leavS));
                pqSize = pqSize + one;
            } else {
                System.out.println("your conditional went wrong");
            }

            /* lab 2
            System.out.println(e.toString());
            System.out.println(e.nextEvent().toString());
            */

            //System.out.println("customer " + counter + s1.canServe(c1));
  
            s1 = s1.setNewBusyUntil(c1);
            counter++;
        }

        //System.out.println(pq.toString());
        /*
        Pair<Event, PQ<Event>> pr = pq.poll();
        Event firstPolled = pr.first();
        pq = pr.second();
        System.out.print(firstPolled.getTime());
        System.out.println(" " + firstPolled);
        */
        //System.out.println(firstPolled.getOrder());
        
        while (!pq.isEmpty()) {
            Pair<Event, PQ<Event>> pr = pq.poll();
            Event polled = pr.first();
            pq = pr.second();
            System.out.println(polled.getTime() + " " + polled);
            
            /*
            pr = pq.poll();
            Event polled = pr.first();
            pq = pr.second();

            System.out.print(polled.getTime());
            System.out.println(" " + polled.toString());
            */

            //System.out.println(polled.getOrder());
        }
        

        /*
        Pair<Event, PQ<Event>> = pq.poll();
        Event polledEvent = pair.first();
        PQ<Event> remainingPQ = pair.second();
        */

        sc.close();
    }
}
