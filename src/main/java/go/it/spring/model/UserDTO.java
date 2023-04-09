package go.it.spring.model;

import go.it.spring.Custom;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    int id;
    String firstName;


    String lastName;
    int age;
}
