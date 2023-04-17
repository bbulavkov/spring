package go.it.spring.controller;

import go.it.spring.entity.Course;
import go.it.spring.mapper.CourseMapper;
import go.it.spring.model.CourseDTO;
import go.it.spring.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO dto) {
        Course created = courseService.create(dto);

        return CourseMapper.from(created);
    }

    @GetMapping
    public List<CourseDTO> getAll() {
        List<Course> courses = courseService.findAll();

        return courses.stream()
                .map(CourseMapper::from)
                .collect(Collectors.toList());
    }
}
