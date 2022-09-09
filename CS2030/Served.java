class Served extends Event {

    Served(Customer customer, Server server) {
        super(customer, server);
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
