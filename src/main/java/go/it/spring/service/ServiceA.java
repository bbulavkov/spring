package go.it.spring.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceA implements SomeService {


    public ServiceA() {
        System.out.println("");
    }

    @Override
    public void service() {
    }
}
