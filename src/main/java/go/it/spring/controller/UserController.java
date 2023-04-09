package go.it.spring.controller;

import go.it.spring.entity.User;
import go.it.spring.mapper.UserMapper;
import go.it.spring.model.UserDTO;
import go.it.spring.security.Roles;
import go.it.spring.service.AuthService;
import go.it.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static go.it.spring.util.UserValidator.validate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AuthService authService;


    @GetMapping
    public List<UserDTO> findAll(@RequestParam(required = false, name = "firstname") String firstName) {
        authService.validateAuthority("ROLE_READ");

        List<User> users = userService.findAll();


        return users.stream()
                .map(UserMapper::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/between")
    public Long findAll(@RequestParam int min, @RequestParam int max) {

        return userService.countBetween(min, max);
    }

//    @GetMapping
//    public List<String> findAll() {
//        List<String> firstNames = userService.findAllFirstNamesGreaterThan5();
//
//        long firstNameCount = userService.countUsersWhereFirstNameGreaterThan5();
//
//        firstNames.add("Users count " + firstNameCount);
//
//        return firstNames;
//    }


    @PostMapping
    public UserDTO create(@RequestBody UserDTO dto) {
        authService.validateAuthority("ROLE_EDITOR");
        validate(dto);

        User user = UserMapper.from(dto);

        user = userService.create(user);

        return UserMapper.from(user);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        authService.validateAuthority("ROLE_DELETE");

        userService.deleteAll();
    }
}
