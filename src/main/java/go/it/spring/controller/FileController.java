package go.it.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
    @PostMapping("/upload")
    public ModelAndView sum(@RequestParam("file") MultipartFile file,
                            @RequestParam("file2") MultipartFile file2,
                            @RequestParam("name") String name) {
        System.out.println(file);
        System.out.println(file2);
        System.out.println(name);

        return null;
    }
}
