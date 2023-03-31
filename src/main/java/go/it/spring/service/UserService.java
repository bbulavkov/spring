package go.it.spring.service;

import go.it.spring.entity.User;
import go.it.spring.repos.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @PostConstruct
    public void init() {
        System.out.println("CLASS " + repository.getClass());
    }

    public List<User> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> findAllByFirsName(String firstName) {
        if (firstName == null) {
            return findAll();

        }
        return repository.findAllByFirstName(firstName);
    }


//    public User get() {
//        return repository.get();
//    }
//
//    public User get(String id) {
//        User user = repository.get();
//        user.setId(id);
//        return user;
//    }
//

//    public User create(User user) {
//        return repository.create(user);
//    }
}
