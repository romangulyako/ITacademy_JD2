package itacademy.comparators;

import java.util.Comparator;

public class FirstWordsThenNumbersComparator implements Comparator<String> {
    private final static String NUMBER_STRING_REGEX = "(-?\\d+\\.?\\d* *)+";
    private final static String SPACE_SPLITERATOR = "\\s+";

    @Override
    public int compare(String o1, String o2) {
        boolean numbersOnlyStr1 = o1.matches(NUMBER_STRING_REGEX);
        boolean numbersOnlyStr2 = o2.matches(NUMBER_STRING_REGEX);

        if (numbersOnlyStr1 && !numbersOnlyStr2) {
            return 1;
        } else if (!numbersOnlyStr1 && numbersOnlyStr2) {
            return -1;
        } else if (numbersOnlyStr1) {
            String[] nums1 = o1.split(SPACE_SPLITERATOR);
            String[] nums2 = o2.split(SPACE_SPLITERATOR);

            int smallestLengthArray = Math.min(nums1.length,nums2.length);

            for (int i = 0; i < smallestLengthArray; i++) {
                Double num1 = Double.parseDouble(nums1[i]);
                Double num2 = Double.parseDouble(nums2[i]);

                if (!num1.equals(num2)) {
                    return num1.compareTo(num2);
                }
            }
            return nums1.length - nums2.length;
        } else {
            return  o1.compareTo(o2);
        }
    }
}
