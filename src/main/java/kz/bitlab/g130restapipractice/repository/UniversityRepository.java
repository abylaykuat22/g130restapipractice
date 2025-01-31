package kz.bitlab.g130restapipractice.repository;

import kz.bitlab.g130restapipractice.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
