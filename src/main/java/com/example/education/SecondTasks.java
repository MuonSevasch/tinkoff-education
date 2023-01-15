package com.example.education;

import java.text.DecimalFormat;

public class SecondTasks {

    public static void evaluate(double a, double b, double h) {
        System.out.println("x\tF(x)");
        for (double x = a; x <= b; x += h) {
            double fx = Math.tan(2 * x) - 3;
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(df.format(x) + "\t" + df.format(fx));
        }
    }
}
