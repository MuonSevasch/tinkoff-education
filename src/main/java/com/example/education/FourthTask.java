package com.example.education;

import java.util.Scanner;

public class FourthTask {

    public static void evaluate(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        double discriminant = b*b - 4*a*c;
        if(discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2*a);
            System.out.println("The solutions are: " + x1 + " and " + x2);
        }else if(discriminant == 0) {
            double x = -b / (2*a);
            System.out.println("The solution is: " + x);
        }else {
            System.out.println("The equation has no real solutions");
        }
    }
}
