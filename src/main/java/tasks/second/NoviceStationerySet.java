package tasks.second;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Собственно набор новичка что бы это не значило.
 * Я прикинул что-то вот такое, о доп функционале речь не шла, так что сорри
 * <p>
 * Так же задача номер 4 реализованна в рамках теста на этот класс, поскльку польностью от него зависит
 */


public class NoviceStationerySet {
    private final ArrayList<Stationery> items;

    public NoviceStationerySet() {
        items = new ArrayList<>();
    }

    public static NoviceStationerySet generateStandart() {
        var temp = new NoviceStationerySet();

        temp.items.add(new Pen("Ballpoint pen", 1.0, "Blue"));
        temp.items.add(new Notebook("Notebook", 2.5, 50));
        temp.items.add(new Pen("Fountain pen", 5.0, "Black"));
        return temp;
    }

    public void addStationery(Stationery s) throws CloneNotSupportedException {
        items.add(s.clone());
    }

    public void shuffleStationery() {
        Collections.shuffle(items);
    }

    public void sortByPrice(){
        items.sort(Comparator.comparingDouble(Stationery::getPrice));
    }
    public void sortByName(){
        items.sort(Comparator.comparing(Stationery::getName));
    }
    public void sortByPriceAndName(){
        items.sort(Comparator.comparingDouble(Stationery::getPrice)
                .thenComparing(Stationery::getName));
    }

    public ArrayList<Stationery> getStationeryList() {
        return (ArrayList<Stationery>) items.clone();
    }
}
