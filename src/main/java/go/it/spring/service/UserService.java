package go.it.spring.service;

import go.it.spring.entity.User;
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
}
