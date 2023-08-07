package com.example.education.third;

import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;

class LegMutexTest {

    @Test
    void movingTestMutex(){
        CompletableFuture.allOf(
            CompletableFuture.runAsync(new LegMutex("left")),
            CompletableFuture.runAsync(new LegMutex("right"))
        ).join();
    }

    @Test
    void movingTest(){
        CompletableFuture.allOf(
            CompletableFuture.runAsync(new LegVolatile("left")),
            CompletableFuture.runAsync(new LegVolatile("right"))
        ).join();
    }

}