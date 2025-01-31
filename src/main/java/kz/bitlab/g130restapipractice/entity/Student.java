package kz.bitlab.g130restapipractice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "STUDENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "AGE")
    private Short age;

    @Column(name = "GPA")
    private Double gpa;

    @JoinColumn(name = "UNIVERSITY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private University university;

    @ManyToMany
    @JoinTable(name = "STUDENT_SUBJECTS",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    private List<Subject> subject;
}
