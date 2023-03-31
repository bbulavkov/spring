package go.it.spring.controller;

import go.it.spring.entity.User;
import go.it.spring.mapper.UserMapper;
import go.it.spring.model.UserDTO;
import go.it.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static go.it.spring.util.UserValidator.validate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

//    @RequestMapping(value = "/user", method = {RequestMethod.GET})
//    public List<UserDTO> getUsersByName(String name) {
//
//        List<User> users = userService.findAllByName(name);
//
//        return users.stream()
//                .map(UserMapper::from)
//                .collect(Collectors.toList());
//
//    }

    @GetMapping
    public List<UserDTO> findAll(@RequestParam(required = false, name = "firstname") String firstName) {
        List<User> users = userService.findAllByFirsName(firstName);

        return users.stream()
                .map(UserMapper::from)
                .collect(Collectors.toList());
    }

//    @GetMapping(path = "/{id}/sometext/{name}",
//            consumes = "application/json",
//            produces = "application/xml")
//    public ModelAndView getUserById(@PathVariable String id,
//                                    @PathVariable String name) {
//
//        ModelAndView result = new ModelAndView("user/current");
//
//        User user = userService.get(id);
////        user.setName(name);
//
//        result.addObject("user", user);
//
//        return result;
//    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO dto) {
        validate(dto);

        User user = UserMapper.from(dto);

        user = userService.create(user);

        return UserMapper.from(user);
    }


//    @PostMapping
//    public UserDTO createUser(@RequestBody UserDTO dto) {
//        User user = UserMapper.from(dto);
//
//        user = userService.create(user);
//
//        return UserMapper.from(user);
//    }

//    @PostMapping
//    public void createUser(HttpServletRequest request,
//                           HttpServletResponse response) throws IOException {
//
//        String requestURI = request.getRequestURI();
//
//        User user = new User();
//        user.setName(requestURI);
//
//        user = userService.create(user);
//
//        UserDTO dto = UserMapper.from(user);
//
//        response.getWriter().write(dto.toString());
//        response.getWriter().close();
//    }
}
