package go.it.spring.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Log4j2
public class SomeService {
    private ApplicationContext context;

    public SomeService(ApplicationContext context) {
        this.context = context;
        System.out.println("SomeService construction");
    }


    @PostConstruct
    public void init() {
        System.out.println("SomeService init");

        System.out.println("CONTEXT" + context);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        Object multipartResolver = context.getBean("multipartResolver");
        System.out.println("RESOLVER" + multipartResolver);
//        someService.init();

        System.out.println("COUNT " + beanDefinitionNames.length);
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
