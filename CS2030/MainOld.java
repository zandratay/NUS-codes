import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();// name of server
        Server s1 = new Server(name, 0.0);

        int counter = 1;

        while (sc.hasNextDouble()) {
            double arrivalTime = sc.nextDouble();
            double serviceTime = sc.nextDouble();
            Customer c1 = new Customer(arrivalTime, serviceTime, arrivalTime + serviceTime,
                          counter);
            Event e = new Arrive(c1, s1);

            System.out.println(e.toString());

            /*
            if (s1.canServeBool(c1)) {
                e = new Served(c1, s1);
                System.out.println(e.toString());
            } else {
                e = new Leave(c1, s1);
                System.out.println(e.toString());
            }
            */

            //System.out.println(e.arriveEventFlow(c1, s1));
            System.out.println(e.nextEvent().toString());
            //System.out.println("customer " + counter + s1.canServe(c1));
            /*
            if (s1.canServeBool(c1)) {
                System.out.println(new Served(c1, s1).toString());
            } else {
                System.out.println(new Leave(c1, s1).toString());
            }
            */

            s1 = s1.setNewBusyUntil(c1);
            counter++;
        }

        sc.close();
    }
}
