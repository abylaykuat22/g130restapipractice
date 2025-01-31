package kz.bitlab.g130restapipractice.service;

import kz.bitlab.g130restapipractice.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents(Short age, Double gpa);

    Student getStudentById(Long id);
}
