package go.it.spring.repos;

import go.it.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    public User get() {
        return new User();
    }

    public User create(User user) {
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
