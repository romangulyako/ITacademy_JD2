package itacademy;


import itacademy.api.IFileHandler;

import java.io.*;

public class FileHandler implements IFileHandler {

    @Override
    public String read(String path) {
        StringBuilder builder = new StringBuilder();

        try (Reader reader = new FileReader(path)) {
            int symbol;

            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }

    @Override
    public void write(String path, String text) {
        try (Writer writer = new FileWriter(path)) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
