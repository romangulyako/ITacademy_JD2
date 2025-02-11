package by.itacademy.jd2.service;

import by.itacademy.jd2.entity.Book;
import by.itacademy.jd2.entity.Reader;
import by.itacademy.jd2.repository.BookRepository;
import by.itacademy.jd2.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    public Reader register(Reader reader) {
        if (readerRepository.findByEmail(reader.getEmail()).isEmpty()) {
            Reader savedReader = readerRepository.save(reader);

            for (Book book : savedReader.getBooks()) {
                book.getReaders().add(savedReader);
                bookRepository.save(book);
            }

            return savedReader;
        }

        return null;
    }

    public Reader findByEmail(String email) {
        return readerRepository.findByEmail(email).orElse(null);
    }

    public Page<Reader> findSortedByRegistrationDate(Pageable pageable) {
        return readerRepository.findAllByOrderByRegistrationDate(pageable);
    }

    public List<Reader> findByAuthor(String authorName) {
        return readerRepository.findReadersByAuthorName(authorName);
    }
}
