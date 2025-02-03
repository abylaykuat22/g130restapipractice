package kz.bitlab.g130restapipractice.dto;

import kz.bitlab.g130restapipractice.entity.University;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityDto {

    private Long id;
    private String location;
    private String name;
}
