package by.itacademy.jd2.repository;

import by.itacademy.jd2.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    Optional<Book> findByIsbn(String isbn);
}
