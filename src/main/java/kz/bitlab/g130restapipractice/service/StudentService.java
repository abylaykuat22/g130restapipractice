package kz.bitlab.g130restapipractice.service;

import kz.bitlab.g130restapipractice.dto.StudentRequestDto;
import kz.bitlab.g130restapipractice.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    List<StudentResponseDto> getStudents(Short age, Double gpa);

    StudentResponseDto getStudentById(Long id);

    void createStudent(StudentRequestDto studentRequestDto);

    void updateGpa(Long id, Double gpa);

    void deleteById(Long id);
}