package tasks.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Собственно набор новичка что бы это не значило.
 * Я прикинул что-то вот такое, о доп функционале речь не шла, так что сорри
 */
public class NoviceStationerySet {
    private List<Stationery> items;

    public NoviceStationerySet() {
        items = new ArrayList<>();
        items.add(new Pen("Ballpoint pen", 1.0, "Blue"));
        items.add(new Notebook("Notebook", 2.5, 50));
        items.add(new Pen("Fountain pen", 5.0, "Black"));
    }

    public List<Stationery> getItems() {
        return items;
    }
}
