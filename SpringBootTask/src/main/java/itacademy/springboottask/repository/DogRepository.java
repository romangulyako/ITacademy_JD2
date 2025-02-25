package itacademy.springboottask.repository;

import itacademy.springboottask.entity.DogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<DogEntity, Long>, DogCustomRepository {
    Page<DogEntity> findByType(String type, Pageable pageable);
}
