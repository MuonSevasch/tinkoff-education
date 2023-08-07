package com.example.education.third;

public class LegMutex implements Runnable {

    private static Object lock = new Object();// Мьютекс для ног
    private final String name;

    public LegMutex(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                System.out.println(name);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}