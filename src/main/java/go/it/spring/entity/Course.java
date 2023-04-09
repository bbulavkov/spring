package go.it.spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@Table(name = "courses", schema = "java_lessons")
@EqualsAndHashCode(exclude = "users")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<User> users;
}

