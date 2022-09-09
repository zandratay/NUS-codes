class Done extends Event {
    //private final Customer c1;
    //private final Server s1;

    Done(Customer customer, Server server) {
        super(customer, server);
    }

    @Override
    public Event nextEvent() {
        return this;
    }

    @Override
    public String toString() {
        return this.getCust() + " done serving by " + this.getServer();
    }
}

