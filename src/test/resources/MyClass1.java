
// Класс только для того чтобы его спарсить
public class MyClass1 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = x + y;
        if (z == 30) {
            System.out.println("The sum is 30");
        } else if (z > 30) {
            System.out.println("The sum is greater than 30");
        } else {
            System.out.println("The sum is less than 30");
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("i is " + i);
        }
        String myString = "Hello World";
        switch (myString) {
            case "Hello":
                System.out.println("The string is Hello");
                break;
            case "World":
                System.out.println("The string is World");
                break;
            default:
                System.out.println("The string is neither Hello nor World");
                break;
        }
        int[] myArray = {1, 2, 3, 4, 5};
        for (int element : myArray) {
            System.out.println("The element is " + element);
        }
        while (x < 20) {
            x++;
            System.out.println("x is " + x);
        }
        do {
            y++;
            System.out.println("y is " + y);
        } while (y < 30);
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("This message will always be printed");
        }
    }
}