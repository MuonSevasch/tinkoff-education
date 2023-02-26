package tasks.second;

public abstract class Stationery {
    private String name;
    private double price;

    public Stationery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}