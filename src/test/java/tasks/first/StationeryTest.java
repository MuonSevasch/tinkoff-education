package tasks.first;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StationeryTest{
    private static final List<String> STATIONERY_NAMES = Arrays.asList("Pen", "Pencil", "Eraser", "Notebook", "Paper", "Stapler", "Staples");

    @Test
    public void firstTaskTest(){
        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee("Employee" + (i + 1));
            addRandomStationeriesToEmployee(employees[i], 3);
        }

        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getTotalStationeryCost());
        }
    }

    private static void addRandomStationeriesToEmployee(Employee employee, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String name = STATIONERY_NAMES.get(random.nextInt(STATIONERY_NAMES.size()));
            double price = random.nextDouble() * 10;
            Stationery stationery = new Stationery(name, price);
            employee.addStationery(stationery);
        }
    }
}