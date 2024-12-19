package itacademy.service.impl;

import itacademy.dto.StudentDto;
import itacademy.service.StudentService;
import itacademy.entity.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private static final List<StudentEntity> repositoryStudent = List.of(
            StudentEntity.builder()
                    .id("1").name("Ivan")
                    .age("25").mark("5")
                    .address("Minsk").build(),
            StudentEntity.builder()
                    .id("2").name("Ivan")
                    .age("25").mark("8")
                    .address("Paris").build(),
            StudentEntity.builder()
                    .id("3").name("Roman")
                    .age("28").mark("9")
                    .address("Minsk").build(),
            StudentEntity.builder()
                    .id("4").name("Kirill")
                    .age("25").mark("6")
                    .address("Minsk").build()
    );

    @Override
    public List<StudentDto> findAll(String name, String age) {
        return repositoryStudent.stream()
                .filter(studentEntity -> studentEntity.getName().equals(name) &&
                        studentEntity.getAge().equals(age))
                .map(studentEntity -> StudentDto.builder()
                        .id(studentEntity.getId())
                        .age(studentEntity.getAge())
                        .name(studentEntity.getName())
                        .mark(studentEntity.getMark())
                        .build())
                .collect(Collectors.toList());
    }
}
