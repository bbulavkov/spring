package go.it.spring.mapper;

import go.it.spring.entity.User;
import go.it.spring.model.UserDTO;

public class UserMapper {

    public static UserDTO from(User user) {
        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAge(user.getAge());

        return dto;
    }

    public static User from(UserDTO dto) {
        User user = new User();

        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAge(dto.getAge());

        return user;
    }
}
