package tasks.second;

public class Notebook extends Stationery {
    private int numberOfPages;

    public Notebook(String name, double price, int numberOfPages) {
        super(name, price);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}