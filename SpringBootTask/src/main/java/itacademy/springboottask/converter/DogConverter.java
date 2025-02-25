package itacademy.springboottask.converter;

import itacademy.springboottask.dto.DogDTO;
import itacademy.springboottask.entity.DogEntity;

public class DogConverter {
    public static DogDTO toDTO(DogEntity dogEntity) {
        if (dogEntity != null) {
            return DogDTO.builder()
                    .id(dogEntity.getId())
                    .name(dogEntity.getName())
                    .type(dogEntity.getType())
                    .age(dogEntity.getAge())
                    .build();
        }

        return null;
    }

    public static DogEntity toEntity(DogDTO dogDTO) {
        if (dogDTO != null) {
            return DogEntity.builder()
                    .id(dogDTO.getId())
                    .name(dogDTO.getName())
                    .type(dogDTO.getType())
                    .age(dogDTO.getAge())
                    .build();
        }

        return null;
    }
}
