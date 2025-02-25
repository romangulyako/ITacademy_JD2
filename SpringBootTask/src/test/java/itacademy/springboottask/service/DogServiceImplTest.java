package itacademy.springboottask.service;

import itacademy.springboottask.MockUtils;
import itacademy.springboottask.dto.DogDTO;
import itacademy.springboottask.entity.DogEntity;
import itacademy.springboottask.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import static itacademy.springboottask.MockConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DogServiceImplTest {
    @Autowired
    private DogService dogService;

    @Autowired
    private DogRepository dogRepository;

    @Test
    void saveOrUpdate() {
        DogDTO dog = MockUtils.createDogDTO(NAME_1, TYPE_1, AGE_1);
        DogDTO savedDog = dogService.saveOrUpdate(dog);

        assertNotNull(savedDog.getId());
        assertEquals(dog.getName(), savedDog.getName());
    }

    @Test
    void findById() {
        DogEntity dog = MockUtils.createDogEntity(NAME_1, TYPE_1, AGE_1);
        DogEntity savedDog = dogRepository.save(dog);

        DogDTO foundDog = dogService.findById(savedDog.getId());

        assertNotNull(foundDog);
        assertEquals(dog.getName(), foundDog.getName());
    }

    @Test
    void findAll() {
        dogRepository.save(MockUtils.createDogEntity(NAME_1, TYPE_1, AGE_1));
        dogRepository.save(MockUtils.createDogEntity(NAME_2, TYPE_2, AGE_2));

        /*Page<DogDTO> foundDogs = dogService.findAll(PAGE, SIZE);

        assertNotNull(foundDogs);
        assertEquals(SIZE, foundDogs.getContent().size());*/
    }

    @Test
    void delete() {
        DogEntity savedDog = dogRepository.save(MockUtils.createDogEntity(NAME_1, TYPE_1, AGE_1));
        dogService.delete(savedDog.getId());
        assertNull(dogService.findById(savedDog.getId()));
    }
}