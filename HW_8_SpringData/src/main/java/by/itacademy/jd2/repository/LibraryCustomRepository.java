package by.itacademy.jd2.repository;

import by.itacademy.jd2.entity.Reader;

import java.util.List;

public interface LibraryCustomRepository {
    List<Reader> findReadersByAuthorName(String authorName);
}
