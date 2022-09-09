class BigCruise extends Cruise {
    private static final int ONE_MIN_SERVE = 50;
    private static final int ONE_LOADER_PER = 1;
    private static final int ONE = 1; // for formula

    BigCruise(String identifier, int arrivalTime, int length, int numPassengers) {
        super(identifier, arrivalTime, (length + ONE_LOADER_PER - ONE) / ONE_LOADER_PER,
                (numPassengers + ONE_MIN_SERVE - ONE) / ONE_MIN_SERVE);
    }
}
