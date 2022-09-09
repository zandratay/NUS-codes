class Cruise {
    private final String identifier;
    private final int arrivalTime;
    private final int numOfLoaders;
    private final int serviceTime;

    Cruise(String identifier, int arrivalTime, int numOfLoaders, int serviceTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.numOfLoaders = numOfLoaders;
        this.serviceTime = serviceTime;
    }

    private String getIden() {
        return this.identifier;
    }

    public int getNumOfLoadersRequired() {
        return this.numOfLoaders;
    }

    private int getterArrTime() {
        return this.arrivalTime;
    }

    public int getServiceTime() {
        return this.serviceTime;
    }
    
    private static final int hundred = 100;
    private static final int sixty = 60;

    public int getArrivalTime() {
        //int hundred = 100;
        //int sixty = 60;
        int arrivalTime = this.getterArrTime();
        int hours = (int)Math.floor(arrivalTime / hundred);
        int mins = arrivalTime % hundred;
        return hours * sixty + mins;
    }

    @Override
    public String toString() {
        return this.getIden() + "@" + String.format("%04d", this.getterArrTime());
    }
}
