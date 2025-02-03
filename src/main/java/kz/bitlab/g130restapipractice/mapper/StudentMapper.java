package kz.bitlab.g130restapipractice.mapper;

import kz.bitlab.g130restapipractice.dto.StudentResponseDto;
import kz.bitlab.g130restapipractice.entity.Student;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true))
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "name", source = "fullName")
    StudentResponseDto toDto(Student entity);

    Student toEntity(StudentResponseDto dto);

    List<StudentResponseDto> toDtoList(List<Student> entities);
}
