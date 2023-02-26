package tasks.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private List<Stationery> stationeries;

    public Employee(String name) {
        this.name = name;
        this.stationeries = new ArrayList<>();
    }

    public void addStationery(Stationery stationery) {
        stationeries.add(stationery);
    }

    public double getTotalStationeryCost() {
        double totalCost = 0.0;
        for (Stationery stationery : stationeries) {
            totalCost += stationery.getPrice();
        }
        return totalCost;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return name.equals(other.name) && stationeries.equals(other.stationeries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stationeries);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", stationeries=" + stationeries +
                '}';
    }
}