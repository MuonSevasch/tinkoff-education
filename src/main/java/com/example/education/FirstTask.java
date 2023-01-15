package com.example.education;

public class FirstTask {

    public static int[] evaluate(){
        int[] numbers = new int[10];


        int x = 0;
        // Fill array with only even numbers
        while (x < numbers.length) {
            numbers[x] = 2 * x;
            x++;
        }

        // Multiply every second element by the previous one
        for (int i = 1; i < numbers.length; i += 2) {
            numbers[i] *= numbers[i - 1];
        }

        // Print the array
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        return numbers;
    }
}
