package go.it.spring.service;

import go.it.spring.entity.Course;
import go.it.spring.entity.User;
import go.it.spring.mapper.CourseMapper;
import go.it.spring.model.CourseDTO;
import go.it.spring.repos.CourseRepository;
import go.it.spring.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    public final UserService userService;

    public Course create(CourseDTO dto) {

        final Course course = CourseMapper.from(dto);
        Set<User> users = userService.findAllByIds(dto.getUserIds());

        users.forEach(u -> {
            Set<Course> courses = u.getCourses();
            courses.add(course);
            u.setCourses(courses);
        });

        course.setUsers(users);

        return repository.save(course);
    }

    public List<Course> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
