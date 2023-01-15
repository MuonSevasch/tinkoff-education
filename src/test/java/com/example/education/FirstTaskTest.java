package com.example.education;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class FirstTaskTest {

    @Test
    public void testArray() {
        int[] expected = {0, 0, 4, 24, 8, 80, 12, 168, 16, 288};
        int[] result = FirstTask.evaluate();
        assertArrayEquals(expected, result);
    }

}
