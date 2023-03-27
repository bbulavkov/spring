package go.it.spring.repos;

import go.it.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    public User get() {
        return new User();
    }
}
