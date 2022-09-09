class Event {
    protected final Customer customer;
    protected final Server server;
    // private final boolean status; // true is served, false is left

    Event(Customer customer, Server server) {
        this.customer = customer;
        this.server = server;
        //this.status = status;
    }

    protected Customer getCust() {
        return this.customer;
    }

    protected Server getServer() {
        return this.server;
    }

    protected Event nextEvent() {
        return this;
    }

    public boolean equal(Event e) {
        //return this.getClass().equals(e.getClass());
        Integer zero = 0;
        Integer comparing = this.toString().compareTo(e.toString());
        return comparing.equals(zero) ? true : false;
    }
 
  
    @Override
    public String toString() {
        /*
        if (this.getServer().canServeBool(this.getCust())) {
            return new Served(this.getCustomer(), this.getServer());
        } else {
            return new Leave(this.getCustomer(), this.getServer());
        }
        */
        return this.getCust() + " " + this.getServer();
    }
}
