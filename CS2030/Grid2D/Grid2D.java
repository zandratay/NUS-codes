import java.util.List;

class Grid2D<E> {
    private final ImList<E> list;
    private final int numOfCols;

    Grid2D(List<E> list, int numOfCols) {
        this.list = new ImList<E>(list); 
        this.numOfCols = numOfCols;
    }

    // overloaded constructor
    Grid2D(ImList<E> list, int numOfCols) {
        this.list = list;
        this.numOfCols = numOfCols;
    }

    // overloaded constructor
    Grid2D(int numOfCols) {
        this.list = new ImList<E>();
        this.numOfCols = numOfCols;
    }

    public ImList<E> getList() {
        return this.list;
    }

    public int getCols() {
        return this.numOfCols;
    }

    Grid2D<E> add(E elem) { 
        Grid2D<E> newGrid = new Grid2D<E>(this.getList().add(elem), this.getCols());
        return newGrid;
    }

    int index(int r, int c) {
        return r * this.getCols() + c;
    }

    public E get(int r, int c) {
        return this.getList().get(index(r, c));
    }

    Grid2D<E> set(int r, int c, E elem) {
        return new Grid2D<E>(this.getList().set(index(r, c), elem), this.getCols());
    }

    @Override
    public String toString() { 
        ImList<E> currList = this.getList();
        int numCols = this.getCols();
        int numRows = (int)Math.ceil(currList.size() / numCols);
        int counter = 0;

        String output = "{";

        if (numCols == currList.size()) {
            for (int k = 0; k < numCols; k++) {
                if (k != numCols - 1) {
                    output = output + currList.get(k) + ",";
                } else {
                    output = output + currList.get(k);
                }
            }
        } else if (numCols == 1) {
            for (int h = 0; h < currList.size(); h++) {
                if (h != currList.size() - 1) {
                    output = output + currList.get(h) + ";";
                } else {
                    output = output + currList.get(h);
                }
            }
        } else {
            for (int i = 0; i < numRows + 1; i++) {
                for (int j = 0; j < numCols; j++) {
                    if (counter > currList.size() - 1) {
                        break;
                    } else {
                        E elem = currList.get(counter);
                        counter = counter + 1;
                        if (counter == currList.size()) {
                            output = output + elem;
                            break;
                        } else if (j == numCols - 1) {
                            output = output + elem + ";";
                        } else {
                            output = output + elem + ",";
                        }
                    }
                }
                if (i == numRows) {
                    output = output;
                } else {
                    output = output;
                }
            }
        }
        return output + "}";
    }
}
