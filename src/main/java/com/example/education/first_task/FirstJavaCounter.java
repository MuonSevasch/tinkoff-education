package com.example.education.first_task;

import java.io.*;
import java.util.*;

public class FirstJavaCounter {
    public static void doTask(String filePath) throws IOException {
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte",
                "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else",
                "enum", "extends", "final", "finally", "float",
                "for", "if", "goto", "implements", "import",
                "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while"};

        int[] counts = new int[keywords.length];

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {

            int data;
            StringBuilder word = new StringBuilder();

            while ((data = fileInputStream.read()) != -1) {
                char character = (char) data;

                if (Character.isWhitespace(character) || character == '(' || character == ')' ||
                        character == '{' || character == '}' || character == ';' || character == '.') {
                    if (word.length() > 0) {
                        String wordString = word.toString();

                        for (int i = 0; i < keywords.length; i++) {
                            if (wordString.equals(keywords[i])) {
                                counts[i]++;
                                break;
                            }
                        }

                        word.setLength(0);
                    }
                } else {
                    word.append(character);
                }
            }
        }

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("output.txt");

            for (int i = 0; i < keywords.length; i++) {
                fileOutputStream.write((keywords[i] + " " + counts[i] + "\n").getBytes());
            }
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
