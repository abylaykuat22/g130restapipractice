package kz.bitlab.g130restapipractice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SUBJECTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TEACHER", nullable = false)
    private String teacher;
}
