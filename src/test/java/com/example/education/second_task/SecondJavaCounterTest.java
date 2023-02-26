package com.example.education.second_task;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SecondJavaCounterTest {

    @Test
    public void doTaskTest() throws IOException {
        SecondJavaCounter.doTask("src/test/resources/MyClass1.java", "second_task_output.txt");
    }

    @Test
    public void doTaskTest2() throws IOException {
        SecondJavaCounter.doTask("src/test/resources/MyClass2.java", "second_task_output_2.txt");
    }

}