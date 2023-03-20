package go.it.spring.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Log4j2
public class SomeService1 {
    private ApplicationContext context;


    public SomeService1(ApplicationContext context) {
        this.context = context;
        System.out.println("SomeService construction");
    }


    @PostConstruct
    public void init() {
        System.out.println("SomeService init");

        ServiceB serviceB = context.getBean(ServiceB.class);

        serviceB.service();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SomeService destroy");
    }
}
