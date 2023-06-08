package com.example.education.first;

import static org.junit.Assert.assertEquals;

import java.util.Objects;
import org.junit.Test;

public class PropertiesReaderTest  {


    @Test
    public void testGetProperty() {
        PropertiesReader reader = new PropertiesReader("src/test/resources/application.properties");

        String value1 = reader.getProperty("keyAlpha");
        String value2 = reader.getProperty("keyBeta");
        assertEquals(value1, "123");
        assertEquals(value2, "I love Java");
    }
}