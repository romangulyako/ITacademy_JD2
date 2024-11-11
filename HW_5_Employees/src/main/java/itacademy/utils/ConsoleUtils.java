package itacademy.utils;

import java.util.Scanner;

public class ConsoleUtils {
    private final static String SEPARATOR = "\n_____________________________________________________________________________";

    public static int inputInt(Scanner console) {
        try {
            return Integer.parseInt(console.next());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static double inputDouble(Scanner console) {
        try {
            return Double.parseDouble(console.next());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void printText(String text) {
        System.out.println(SEPARATOR);
        System.out.print(text);
    }
}
