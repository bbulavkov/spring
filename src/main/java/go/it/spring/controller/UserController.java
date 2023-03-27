package go.it.spring.controller;

import go.it.spring.entity.User;
import go.it.spring.mapper.UserMapper;
import go.it.spring.model.UserDTO;
import go.it.spring.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDateTime;

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

//    @RequestMapping(value = "/user", method = {RequestMethod.GET})
//    public ModelAndView getUser() {
//        ModelAndView result = new ModelAndView("user/current");
////mapping request for service layer
//
//        User user = userService.get();
//
//        result.addObject("user", user);
//
//
//        return result;
//    }

    @GetMapping
    public ModelAndView getUser() {
        ModelAndView result = new ModelAndView("user/current");
//mapping request for service layer

        User user = userService.get();

        result.addObject("user", user);


        return result;
    }

    @GetMapping(path = "/{id}/sometext/{name}",
            consumes = "application/json",
            produces = "application/xml")
    public ModelAndView getUserById(@PathVariable String id,
                                    @PathVariable String name) {

        ModelAndView result = new ModelAndView("user/current");

        User user = userService.get(id);
        user.setName(name);

        result.addObject("user", user);

        return result;
    }

//    @PostMapping
//    public ModelAndView createUser(
////            @RequestHeader("Content-Type") String contentType,
//            @CookieValue("mvc") String mvcCookie,
//            @RequestBody UserDTO dto) {
//        ModelAndView result = new ModelAndView("user/current");
////mapping request for service layer
//
//        User user = UserMapper.from(dto);
//
//        user = userService.create(user);
//
//        dto = UserMapper.from(user);
//
//        dto.setName(mvcCookie);
//
//        result.addObject("user", dto);
//
//        return result;
//    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO dto) {
        User user = UserMapper.from(dto);

        user = userService.create(user);

        return UserMapper.from(user);
    }

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
