package kz.bitlab.g130restapipractice.repository;

import kz.bitlab.g130restapipractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
