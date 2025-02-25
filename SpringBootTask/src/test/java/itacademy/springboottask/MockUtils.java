package itacademy.springboottask;

import itacademy.springboottask.dto.DogDTO;
import itacademy.springboottask.entity.DogEntity;

public class MockUtils {
    public static DogDTO createDogDTO(String name, String type, Integer age) {
        return DogDTO.builder()
                .name(name)
                .type(type)
                .age(age)
                .build();
    }

    public static DogEntity createDogEntity(String name, String type, Integer age) {
        return DogEntity.builder()
                .name(name)
                .type(type)
                .age(age)
                .build();
    }
}
