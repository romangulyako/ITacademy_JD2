package by.itacademy.jd2.service;

import by.itacademy.jd2.entity.Book;
import by.itacademy.jd2.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book save(Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()).isEmpty()) {
            return bookRepository.save(book);
        }

        return null;
    }

    public List<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContaining(title);
    }
}
