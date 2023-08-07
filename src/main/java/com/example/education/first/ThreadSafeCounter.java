package com.example.education.first;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {

    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public int getValue() {
        return counter.get();
    }
}