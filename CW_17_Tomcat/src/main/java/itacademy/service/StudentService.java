package itacademy.service;

import itacademy.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll(String name, String age);
}
