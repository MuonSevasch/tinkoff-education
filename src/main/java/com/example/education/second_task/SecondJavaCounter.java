package com.example.education.second_task;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SecondJavaCounter {
    public static void doTask(String inputFileName, String outputFileName) throws IOException {

        Map<String, Integer> keywordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (isJavaKeyword(word)) {

                        int count = keywordCountMap.getOrDefault(word, 0);
                        keywordCountMap.put(word, count + 1);
                    }
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Integer> entry : keywordCountMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }

    private static boolean isJavaKeyword(String word) {
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
                "finally", "float", "for", "if", "goto", "implements", "import", "instanceof",
                "int", "interface", "long", "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
                "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};
        return Arrays.asList(keywords).contains(word);
    }

}
