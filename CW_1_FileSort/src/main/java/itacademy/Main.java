package itacademy;

import itacademy.api.IFileHandler;
import itacademy.comparators.FirstWordsThenNumbersComparator;
import itacademy.utils.SortUtils;

public class Main {
    private final static String OUT_FILE_PATH = "./src/main/java/itacademy/resourсes/out.txt";
    private final static String IN_FILE_PATH = "./src/main/java/itacademy/resourсes/in.txt";

    public static void main(String[] args) {
        IFileHandler fileHandler = new FileHandler();

        String text = fileHandler.read(IN_FILE_PATH);
        String sortedText = SortUtils.sortByWordsAndLines(text,new FirstWordsThenNumbersComparator());
        fileHandler.write(OUT_FILE_PATH,sortedText);
    }
}