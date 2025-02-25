package itacademy.springboottask.service;

import itacademy.springboottask.converter.DogConverter;
import itacademy.springboottask.dto.DogDTO;
import itacademy.springboottask.dto.FilterData;
import itacademy.springboottask.entity.DogEntity;
import itacademy.springboottask.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;

    @Override
    public DogDTO saveOrUpdate(DogDTO dog) {
        DogEntity entity = DogConverter.toEntity(dog);
        return DogConverter.toDTO(dogRepository.save(entity));
    }

    @Override
    public DogDTO findById(Long id) {
        return DogConverter.toDTO(dogRepository.findById(id).orElse(null));
    }

    @Override
    public Page<DogDTO> findAll(FilterData filter) {
        return dogRepository.findByFilter(filter)
                .map(DogConverter::toDTO);
    }

    @Override
    public void delete(Long id) {
        dogRepository.deleteById(id);
    }

    @Override
    public Page<DogDTO> findByType(String type, int page, int size) {
        return dogRepository.findByType(type, PageRequest.of(page, size))
                .map(DogConverter::toDTO);
    }
}
