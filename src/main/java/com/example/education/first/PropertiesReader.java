package com.example.education.first;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {
    private final Map<String, String> propertiesMap;

    public PropertiesReader(String filePath) {
        propertiesMap = new HashMap<>();
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(fis);

            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                propertiesMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return propertiesMap.get(key);
    }
}