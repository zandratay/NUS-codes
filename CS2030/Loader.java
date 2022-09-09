class Loader {
    private final int identifier;
    private final int numOfLoaders;

    Loader(int identifier, int numOfLoaders) {
        this.identifier = identifier;
        this.numOfLoaders = numOfLoaders;
    }

    private int getIdentifier() {
        return this.identifier;
    }

    private static final int FIRST_ID = 1;

    // overloaded constructor method
    Loader(int numOfLoaders) {
        this.identifier = FIRST_ID;
        this.numOfLoaders = numOfLoaders;
    }

    private int getNumOfLoaders() {
        return this.numOfLoaders;
    }

    public Loader nextLoader() {
        int fixedAtOne = 1;
        int one = 1;

        int num = this.getNumOfLoaders();
        int newId = this.getIdentifier();

        if (newId < num) {
            return new Loader(newId + one, num);
        } else {
            newId = fixedAtOne;
            return new Loader(newId, num);
        }
    }

    public Loader prevLoader() {
        int one = 1;

        int num = this.getNumOfLoaders();
        int newId = this.getIdentifier();

        if (newId == 1) {
            return new Loader(num, num);
        } else {
            return new Loader(newId - one, num);
        }
    }

    @Override
    public String toString() {
        return "Loader #" + this.getIdentifier();
    }
}
