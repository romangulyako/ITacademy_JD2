package itacademy.springboottask.service;

import itacademy.springboottask.dto.DogDTO;
import itacademy.springboottask.dto.FilterData;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DogService {
    DogDTO saveOrUpdate(DogDTO dog);
    DogDTO findById(Long id);
    Page<DogDTO> findAll(FilterData filter);
    void delete(Long id);
    Page<DogDTO> findByType(String type, int page, int size);

}
