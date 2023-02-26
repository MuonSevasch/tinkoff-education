package tasks.first;

import java.util.Objects;

public class Stationery {
    private String name;
    private double price;

    public Stationery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = (double) price;
    }

    public void setPrice(long price) {
        this.price = (double) price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Stationery)) return false;
        Stationery other = (Stationery) obj;
        return name.equals(other.name) && Double.compare(price, other.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}