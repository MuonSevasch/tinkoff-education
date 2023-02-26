package tasks.second;

import lombok.ToString;

@ToString
public abstract class Stationery implements Cloneable{
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
    @Override
    public Stationery clone() throws CloneNotSupportedException {
        return (Stationery) super.clone();
    }
}