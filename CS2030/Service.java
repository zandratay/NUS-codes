class Service {
    private final Loader loader;
    private final Cruise cruise;
    private final int timeOfService;

    Service(Loader loader, Cruise cruise, int timeOfService) {
        this.loader = loader;
        this.cruise = cruise;
        this.timeOfService = timeOfService;
    }

    private Loader getLoader() {
        return this.loader;
    }

    private Cruise getCruise() {
        return this.cruise;
    }

    private int getterTimeOfService() {
        return this.timeOfService;
    }

    private static final int sixty = 60;

    public String getTimeOfService() {
        //int sixty = 60;
        String hours = String.format("%02d", this.getterTimeOfService() / sixty);
        String mins = String.format("%02d", this.getterTimeOfService() % sixty);
        return hours + mins;
    }

    @Override
    public String toString() {
        return this.getTimeOfService() + " : " + this.getLoader() + " serving "
            + this.getCruise().toString();
    }
}
