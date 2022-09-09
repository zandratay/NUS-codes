class SmallCruise extends Cruise {
    private static final int SVC_TIME = 30;
    private static final int NUM_LOADERS = 1;

    SmallCruise(String identifier, int arrivalTime) {
        super(identifier, arrivalTime, NUM_LOADERS, SVC_TIME);
    }
}
