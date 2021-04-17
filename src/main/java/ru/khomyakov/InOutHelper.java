package ru.khomyakov;

import java.io.*;

public class InOutHelper {
    private static void print(String message) {
        System.out.println(message);
    }

    public static String read() throws IOException {
        print("Enter your birthday in format \"dd.MM.yyyy\": ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }

    public static void printResult(int result) {
        print("Day before your birthday: " + result);
    }

}
