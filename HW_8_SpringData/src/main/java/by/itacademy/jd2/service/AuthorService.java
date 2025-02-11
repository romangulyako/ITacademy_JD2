package by.itacademy.jd2.service;

import by.itacademy.jd2.entity.Author;
import by.itacademy.jd2.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findByNationality(String nationality) {
        return authorRepository.findByNationality(nationality);
    }
}
