package kz.bitlab.g130restapipractice.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import kz.bitlab.g130restapipractice.dto.StudentRequestDto;
import kz.bitlab.g130restapipractice.dto.StudentResponseDto;
import kz.bitlab.g130restapipractice.entity.Student;
import kz.bitlab.g130restapipractice.exception.EntityNotFoundException;
import kz.bitlab.g130restapipractice.exception.IncorrectValueException;
import kz.bitlab.g130restapipractice.mapper.StudentMapper;
import kz.bitlab.g130restapipractice.repository.StudentRepository;
import kz.bitlab.g130restapipractice.repository.UniversityRepository;
import kz.bitlab.g130restapipractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    @Override
    public List<StudentResponseDto> getStudents(Short age, Double gpa) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();
        if (age != null) {
            predicates.add(cb.equal(root.get("age"), age));
        }

        if (gpa != null) {
            predicates.add(cb.equal(root.get("gpa"), gpa));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        List<Student> students = entityManager.createQuery(cq).getResultList();
        return StudentMapper.INSTANCE.toDtoList(students);
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> StudentMapper.INSTANCE.toDto(student))
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    @Override
    public void createStudent(StudentRequestDto request) {
        Student student = new Student();
        student.setAge(request.getAge());
        student.setFullName(request.getName());
        student.setUniversity(universityRepository.findById(request.getUniversityId())
                .orElseThrow(() -> new EntityNotFoundException("University not found")));

        Short entPoints = request.getEntPoints();
        if (entPoints > 130) {
            student.setGpa(4.0);
        } else if (entPoints > 100) {
            student.setGpa(3.5);
        } else if (entPoints > 80) {
            student.setGpa(3.0);
        } else if (entPoints > 50) {
            student.setGpa(2.0);
        } else {
            student.setGpa(1.0);
        }

        studentRepository.save(student);
    }

    @Override
    public void updateGpa(Long id, Double gpa) {
        if (gpa == null || gpa < 0 || gpa > 4) {
            throw new IncorrectValueException();
        }
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        student.setGpa(gpa);
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        studentRepository.delete(student);
    }
}
