package go.it.spring.mapper;

import go.it.spring.entity.User;
import go.it.spring.model.UserDTO;

public class UserMapper {

    public static UserDTO from(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }

    public static User from(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        return user;
    }
}
