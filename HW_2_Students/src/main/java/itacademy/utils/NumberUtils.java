package itacademy.utils;

import java.util.concurrent.ThreadLocalRandom;

public class NumberUtils {
    private final static double COEFFICIENT_FOR_ROUND = 10;

    /**
     * Метод округляет число с плавающей точкой
     * до одного знака после запятой
     *
     * @param number число, которое необходимо округлить
     * @return округленное число
     */
    public static double roundToOneDecimalPlaces(double number) {
        return Math.round(number * COEFFICIENT_FOR_ROUND) / COEFFICIENT_FOR_ROUND;
    }

    /**
     * Метод генерирует случайное число в промежутке между
     * минимальным и максимальным, переданными в параметры.
     * Число округляется до одного знака после запятой
     *
     * @param min минимально возможное число
     * @param max максимально возможное число
     * @return случайное число
     */
    public static double getRandomNumber(double min, double max) {
        double number = ThreadLocalRandom.current().nextDouble(min,max);
        return roundToOneDecimalPlaces(number);
    }
}
