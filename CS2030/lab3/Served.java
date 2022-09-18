class Served extends Event {

    Served(Customer customer, Server server, double time, int order) {
        super(customer, server, time, order);
    }

    /*
    private Customer getCust() {
        return this.customer;
    }

    private Server getServer() {
        return this.server;
    }
    */

    @Override
    public Event nextEvent() {
        return this;
    }

    @Override 
    public String toString() {
        return this.getCust() + " served by " + this.getServer();
    }
}
