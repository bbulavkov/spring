package go.it.spring.mapper;

import go.it.spring.entity.Course;
import go.it.spring.entity.User;
import go.it.spring.model.CourseDTO;

import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseDTO from(Course course) {
        CourseDTO dto = new CourseDTO();

        dto.setId(course.getId());
        dto.setUserIds(course.getUsers().stream().map(User::getId).collect(Collectors.toSet()));
        dto.setName(course.getName());

        return dto;
    }

    public static Course from(CourseDTO dto) {
        Course course = new Course();

        course.setId(dto.getId());
        course.setName(dto.getName());

        return course;
    }
}
