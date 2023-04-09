package go.it.spring.repos;

import go.it.spring.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
//    List<User> findAllByFirstName(String firstName);

    @Query("from User u where u.firstName = :firstName ")
    List<User> findAllByFirstName(String firstName);

    @Query(value = "select * from java_lessons.users " +
            "where first_name = :firstName ",
            nativeQuery = true
    )
    List<User> findAllByFirstNameNative(String firstName);

    @Query("SELECT count(u) FROM User u WHERE length(u.firstName) > 5")
    long countUsersWhereFirstNameGreaterThan5();

    @Query("SELECT u.firstName FROM User u WHERE length(u.firstName) > 5")
    List<String> findAllFirstNamesGreaterThan5();

    @Modifying
    @Query(value = "DELETE FROM java_lessons.users",
            nativeQuery = true)
    void clearAllUsers();

    @Query(nativeQuery = true,
            value = "SELECT count(*) FROM java_lessons.users " +
                    "WHERE length(first_name) >= :min_length " +
                    "AND length(last_name) <= :max_length")
    long countWithSpecificLength(@Param(value = "min_length") int minLength,
                                 @Param(value = "max_length") int maxLength);


    //    List<User> findAllByEmail(String email);

//    List<User> findAllByLastNameAndAgeAndByLastNameAndAge(String lastName, int age, Pageable pageable);
//
//    List<User> findAllByLastNameAndAge(String lastName, int age, Sort sort);
}
