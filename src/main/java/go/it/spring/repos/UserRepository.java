package go.it.spring.repos;

import go.it.spring.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAllByFirstName(String firstName);

//    List<User> findAllByEmail(String email);

//    List<User> findAllByLastNameAndAge(String lastName, int age, Pageable pageable);
//
//    List<User> findAllByLastNameAndAge(String lastName, int age, Sort sort);
}
