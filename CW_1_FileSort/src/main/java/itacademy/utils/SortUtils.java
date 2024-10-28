package itacademy.utils;

import java.util.Arrays;
import java.util.Comparator;

public class SortUtils {
    private final static String SPACE_SPLITERATOR = "\\s+";
    private final static String NEW_LINE_SPLITERATOR = "\n+";
    private final static String SPACE_SYMBOL = " ";
    private final static String NEW_LINE_SYMBOL = "\n";

    public static String sortByWordsAndLines(String text, Comparator<String> cmp) {
        String[] lines = text.split(NEW_LINE_SPLITERATOR);
        for (int i = 0; i < lines.length; i++) {
            lines[i] = sortText(lines[i],cmp,SPACE_SPLITERATOR,SPACE_SYMBOL);
        }
        text = TextUtils.arrayToString(lines,NEW_LINE_SYMBOL);

        return sortText(text,cmp,NEW_LINE_SPLITERATOR,NEW_LINE_SYMBOL);
    }

    public static String sortText(String text, Comparator<String> cmp, String splitRegEx, String separator) {
        String[] items = text.split(splitRegEx);
        Arrays.sort(items,cmp);
        return TextUtils.arrayToString(items,separator);
    }
}
