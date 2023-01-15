package com.example.education;

public class ThirdTask {

    public static void evaluate() {

        int[][] array = new int[5][8];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 100);
            }
        }

        int[][] minMax = new int[5][2];

        for (int i = 0; i < array.length; i++) {
            int min = array[i][0];
            int max = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
            minMax[i][0] = min;
            minMax[i][1] = max;
        }

        System.out.println("Original Array: ");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println("Min/Max Array: ");
        for (int[] max : minMax) {
            for (int i : max) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
