package itacademy.springboottask.repository;

import itacademy.springboottask.dto.FilterData;
import itacademy.springboottask.entity.DogEntity;
import org.springframework.data.domain.Page;

public interface DogCustomRepository {
    Page<DogEntity> findByFilter(FilterData filter);
}
