package go.it.spring.service;

import go.it.spring.Custom;
import go.it.spring.entity.User;
import go.it.spring.repos.UserRepository;
import jakarta.annotation.PostConstruct;
//import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Set<User> findAllByIds(Set<Integer> ids) {
        return repository.findAllByIdIn(ids);
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> findAllByFirsName(String firstName) {
        if (firstName == null) {
            return findAll();

        }
        return repository.findAllByFirstNameNative(firstName);
    }

    public List<String> findAllFirstNamesGreaterThan5() {
        return repository.findAllFirstNamesGreaterThan5();
    }

    public long countUsersWhereFirstNameGreaterThan5() {
        return repository.countUsersWhereFirstNameGreaterThan5();
    }

    public long countBetween(int min, int max) {
        return repository.countWithSpecificLength(min, max);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }


    // Proxy &434 extends UserService
    // Session session;

    //clearAll() {
    //   tr = session.beginTransaction();
    //      clearAll();
    //   tr.commit();
    // catch(Exception){
    //    tr.rollBack();
    // }
    // }


//    @Transactional
//    //tr = session.beginTransaction();
//    public void clearAll() {
//        EntityTransaction transaction1 = entityManager.getTransaction();
//        transaction1.begin();
//
//        Transaction transaction = session.beginTransaction();
//        try {
//            delete();
//            transaction.commit();
//        } catch (Exception ex) {
//            transaction.rollback();
//        }
//
//
//    }
    //tr.commit();


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete() {
        //bla.bla
    }

    public List<User> findAllByFirstNameTemplate(String firstName) {

        RowMapper<User> userRowMapper = (rs, rowNum) -> {

            User user = new User();

            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setAge(rs.getInt("age"));

            return user;
        };


        return namedParameterJdbcTemplate.query(
                "SELECT * FROM java_lessons.users " +
                        "WHERE first_name LIKE :firstName",
                Map.of("firstName", firstName),
                userRowMapper
        );
    }

}
