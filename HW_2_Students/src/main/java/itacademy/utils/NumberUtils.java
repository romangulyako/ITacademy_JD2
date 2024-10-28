package itacademy.utils;

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
}
