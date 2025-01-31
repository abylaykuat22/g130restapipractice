package kz.bitlab.g130restapipractice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "UNIVERSITIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOCATION", nullable = false, length = 200)
    private String location;

    @Column(name = "NAME", nullable = false)
    private String name;
}
