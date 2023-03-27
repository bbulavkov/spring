package go.it.spring.service;

import go.it.spring.entity.User;
import go.it.spring.model.UserDTO;
import go.it.spring.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User get() {
        return repository.get();
    }

    public User get(String id) {
        User user = repository.get();
        user.setId(id);
        return user;
    }

    public User create(String name) {
        User user = new User();
        user.setName(name);
        //....

        return repository.create(user);
    }

    public User create(User user) {
        return repository.create(user);
    }
}
