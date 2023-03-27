package go.it.spring.controller;

import go.it.spring.entity.User;
import go.it.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    public ModelAndView getTime() {
        ModelAndView result = new ModelAndView("user/current");
//mapping request for service layer

        User user = userService.get();

        result.addObject("user", user);


        return result;
    }

    @RequestMapping(value = "/time1", method = {RequestMethod.GET})
    public ModelAndView getTime1() {
        ModelAndView result = new ModelAndView("time/current");
        result.addObject("now1", LocalDateTime.now());
        return result;
    }
}
