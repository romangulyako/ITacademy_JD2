package by.itacademy.jd2.repository;

import by.itacademy.jd2.entity.Reader;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LibraryCustomRepositoryImpl implements LibraryCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Reader> findReadersByAuthorName(String authorName) {
        String query = "SELECT DISTINCT r FROM Reader r JOIN r.books b " +
                "WHERE b.author.name = :authorName";

        return entityManager.createQuery(query, Reader.class)
                .setParameter("authorName", authorName)
                .getResultList();
    }
}

