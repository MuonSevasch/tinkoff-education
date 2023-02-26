package com.example.education.first_task;

import org.junit.Test;

import java.io.IOException;

public class FirstJavaCounterTest {

    @Test
    public void firstJavaCounterTest() throws IOException {
        FirstJavaCounter.doTask("src/test/resources/MyClass1.java");
    }

}