package by.itacademy.jd2.repository;

import by.itacademy.jd2.entity.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends PagingAndSortingRepository<Reader, Long>, LibraryCustomRepository {
    Optional<Reader> findByEmail(String email);
    Page<Reader> findAllByOrderByRegistrationDate(Pageable pageable);
}
