class Customer {
    //private final int customerNumber;
    private final double arrivalTime;
    private final double serveTime;
    private final double leaveTime;
    private final int custNum;

    Customer(double arrivalTime, double serveTime, double leaveTime, int custNum) {
        //this.customerNumber = customerNumber;
        this.arrivalTime = arrivalTime;
        this.serveTime = serveTime;
        this.leaveTime = leaveTime;
        this.custNum = custNum;
    }

    //private int getCustNum() {
    //    return this.customerNumber;
    //}

    private double getArrivalTime() {
        return this.arrivalTime;
    }

    private double getServeTime() {
        return this.serveTime;
    }

    private double getLeaveTime() {
        return this.leaveTime;
    }

    private int getCustNum() {
        return this.custNum;
    }

    @Override
    public String toString() {
        return "customer " + this.getCustNum();
    }
    
    public double leaveTime() {
        return this.getLeaveTime();
    }

    public double arrivalTime() {
        return this.getArrivalTime();
    }
}
