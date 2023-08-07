package com.example.education.third;

public class LegVolatile implements Runnable {

    public static volatile boolean currentLeg = true;
    private final String name;
    private final boolean leg;

    public LegVolatile(String name) {
        this.name = name;
        if (name.equals("left")) {
            this.leg = true;
        } else {
            this.leg = false;
        }
    }

    @Override
    public void run() {
        while (true) {
            if (leg == currentLeg) {
                System.out.println(name);
                currentLeg = !leg;
                Thread.yield();
            }
        }
    }
}