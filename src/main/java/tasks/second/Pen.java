package tasks.second;

import lombok.ToString;

public class Pen extends Stationery {
    private String color;

    public Pen(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}