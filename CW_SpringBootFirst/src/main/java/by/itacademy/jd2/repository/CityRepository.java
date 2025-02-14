package by.itacademy.jd2.repository;

import by.itacademy.jd2.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    CityEntity findByName(String name);
}
