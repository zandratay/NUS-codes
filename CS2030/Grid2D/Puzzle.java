class Puzzle {
    private final Grid2D<String> grid;
    private final int n;

    Puzzle(int n) {
        Grid2D<String> loopyGrid = new Grid2D<String>(n);
        int nsquared = n * n;
        
        for (int i = 0; i < nsquared - 1; i++) {
            int toAdd = i + 1;
            loopyGrid = loopyGrid.add(Integer.toString(i + 1));
        }
        loopyGrid = loopyGrid.add(".");
        this.grid = loopyGrid;
        this.n = n;
    }

    // overloaded constructor
    Puzzle(Grid2D<String> grid, int n) {
        this.grid = grid;
        this.n = n;
    }

    private int getN() {
        return this.n;
    }

    private Grid2D<String> getGrid() {
        return this.grid;
    }

    Puzzle move(int num) {
        Grid2D<String> ourGrid = this.getGrid();
        int n = this.getN();
        ImList<String> ourList = ourGrid.getList();
        int ourCols = ourGrid.getCols();
        int ourRows = (int)Math.ceil(ourList.size() / ourCols) + 1;
        int counter = 0;

        // store the found index for dot and num
        Integer rowIndexNum = 0;
        Integer colIndexNum = 0;
        Integer rowIndexDot = 0;
        Integer colIndexDot = 0;

        Integer zero = 0;

        // loop thru to find the row and col index of dot and num
        for (int i = 0; i < ourRows; i++) {
            for (int j = 0; j < ourCols; j++) {
                if (counter > ourList.size() - 1) {
                    break;
                } else {
                    String elem = ourList.get(counter);
                    counter = counter + 1;
                    if (elem.compareTo(Integer.toString(num)) == 0) {
                        rowIndexNum = i;
                        colIndexNum = j;
                    } else if (elem.compareTo(".") == 0) {
                        rowIndexDot = i;
                        colIndexDot = j;
                    }
                }
            }
        }

        // now check and set positioning
        Integer colComp1 = Integer.compare(colIndexNum, colIndexDot + 1);
        Integer colComp2 = Integer.compare(colIndexNum, colIndexDot - 1);
        Integer rowComp1 = Integer.compare(rowIndexNum, rowIndexDot + 1);
        Integer rowComp2 = Integer.compare(rowIndexNum, rowIndexDot - 1);
        if (Integer.compare(rowIndexNum, rowIndexDot) == 0) {
            if (colComp1 == 0 || colComp2 == 0) {
                ourGrid = ourGrid.set(rowIndexNum, colIndexNum, ".");
                ourGrid = ourGrid.set(rowIndexDot, colIndexDot, Integer.toString(num));
            }
        } else if (Integer.compare(colIndexNum, colIndexDot) == 0) {
            if (rowComp1 == 0 || rowComp2 == 0) {
                ourGrid = ourGrid.set(rowIndexNum, colIndexNum, ".");
                ourGrid = ourGrid.set(rowIndexDot, colIndexDot, Integer.toString(num));
            }
        } else {
            ourGrid = ourGrid;
        }
        return new Puzzle(ourGrid, n);
    }

    boolean isSolved() {
        int dimension = this.getN();
        return this.toString().compareTo(new Puzzle(dimension).toString()) == 0 ? true : false;
    }

    @Override
    public String toString() {
        String output = "\n";
        Grid2D<String> outputGrid = this.getGrid();

        for (int i = 0; i < this.getN(); i++) {
            for (int j = 0; j < this.getN(); j++) {
                String currElem = outputGrid.get(i, j);
                if (j != this.getN() - 1) {
                    output = output + currElem + "\s";
                } else {
                    output = output + currElem;
                }
                //output = output + currElem;
            } 
            output = output + "\n";
        }
        return output;
    }
}

