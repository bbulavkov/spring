package go.it.spring.util;

import go.it.spring.model.UserDTO;

public class UserValidator {

    public static void validate(UserDTO dto) {
        if (dto.getFirstName() == null) {
            throw new RuntimeException("First name must be present.");

        }

        if (dto.getLastName() == null) {
            throw new RuntimeException("Last name must be present.");
        }

        if (dto.getAge() < 0) {
            throw new RuntimeException("Age must be >=0");
        }

    }
}
