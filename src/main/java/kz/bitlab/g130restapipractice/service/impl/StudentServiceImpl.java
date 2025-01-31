package kz.bitlab.g130restapipractice.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import kz.bitlab.g130restapipractice.entity.Student;
import kz.bitlab.g130restapipractice.repository.StudentRepository;
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

    @Override
    public List<Student> getStudents(Short age, Double gpa) {
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
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }
}
