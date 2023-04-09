package go.it.spring.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDTO {
    int id;
    Set<Integer> userIds;
    String name;
}
