package itacademy.api;

public interface IFileHandler {
    String read(String path);
    void write(String path, String text);
}
