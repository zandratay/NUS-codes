class Server {
    private final String serverName;
    //private final Customer cust;
    private final double busyUntil;
    //private final boolean flag;

    Server(String serverName, double busyUntil) {
        this.serverName = serverName;
        //this.cust = cust;
        this.busyUntil = busyUntil;
        //this.flag = flag;
    }

    private String getName() {
        return this.serverName;
    }

    private double getBusyUntil() {
        return this.busyUntil;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public Server setNewBusyUntil(Customer cust) {
        if (this.getBusyUntil() <= cust.arrivalTime()) {
            return new Server(this.getName(), cust.leaveTime());
        } else {
            return this;
        }
    }

    /*
     * DO NOT REMOVE!!!!!
    public String canServe(Customer cust) {
        if (this.getBusyUntil() <= cust.arrivalTime()) {
            return " served by " + this.getName();
        } else {
            return " left";
        }
    }
    */

    public boolean canServeBool(Customer cust) {
        /*
        if (this.getBusyUntil() <= cust.arrivalTime()) {
            return true;
        } else {
            return false;
        }
        */
        return this.getBusyUntil() <= cust.arrivalTime();
    }
}
