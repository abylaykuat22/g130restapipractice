package kz.bitlab.g130restapipractice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDto {

    private String name;
    private Short age;
    private Short entPoints;
    private Long universityId;
}
