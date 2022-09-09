class Book {
    private final int currentPage;
    private final int totalPages;
    Book(int currentPage, int totalPages) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }
    private int getCurrentPage() {
        return this.currentPage;
    }
    private int getTotalPages() {
        return this.totalPages;
    }
    public String toString() {
        return "I am at page " + this.getCurrentPage() + " of my book, which is " + this.getTotalPages() + " pages long.";
    }
    Book nextPage() {
        if (this.getCurrentPage() + 1 > this.getTotalPages()) {
            return this;
        } else {
            return new Book(this.getCurrentPage() + 1, this.getTotalPages());
        }
    }
    Book prevPage() {
        if (this.getCurrentPage() - 1 < 1) {
            return this;
        } else {
            return new Book(this.getCurrentPage() - 1, this.getTotalPages());
        }
    }
    Book goToPage(int pageNumber) {
        if (pageNumber > this.getTotalPages() || pageNumber < 1) {
            return this;
        } else {
            return new Book(pageNumber, this.getTotalPages());
        }
    }
}

public class rec2 {
    public static void main(String[] args) {
        Book b1 = new Book(5, 200);
        Book b2 = new Book(300, 300);

        System.out.println(b1.nextPage().toString());
        System.out.println(b2.prevPage().toString());
    }
}
