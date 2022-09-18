class Arrive extends Event {
    //super(customer);
    //super(server);
    
    Arrive(Customer customer, Server server, double time, int order) {
        super(customer, server, time, order);
    }
    /*
    public static Event arriveEventFlow(Customer c1, Server s1) {
        if (s1.canServeBool(c1)) {
            return new Served(c1, s1);
        } else {
            return new Leave(c1, s1);
        }
    }
    */

    @Override
    public Event nextEvent() {
        if (this.getServer().canServeBool(this.getCust())) {
            return new Served(this.getCust(), this.getServer(), this.getTime(), this.getOrder());
        } else {
            return new Leave(this.getCust(), this.getServer(), this.getTime(), this.getOrder());
        }
    }

    //@Override
    /*
    public boolean equal(Event e) {
        //return this.getClass().equals(e.getClass());
        Integer zero = 0;
        Integer comparing = this.toString().compareTo(e.toString());
        return comparing.equals(zero) ? true : false;
    }
    */

    @Override
    public String toString() {
        return this.getCust() + " arrives";
    }
}

