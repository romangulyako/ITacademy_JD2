package itacademy.utils;

public class TextUtils {
    public static String arrayToString(String[] array, String separator) {
        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < array.length; j++) {
            builder.append(array[j]);
            if (j != array.length - 1) {
                builder.append(separator);
            }
        }

        return builder.toString();
    }
}
