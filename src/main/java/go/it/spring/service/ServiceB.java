package go.it.spring.service;

import go.it.spring.entity.User;
import go.it.spring.util.CounterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceB implements SomeService {

    // field inject
//    @Autowired
    private final SomeService serviceA_2;

    private SomeService serviceA;


    //     construct inject
//    public ServiceB(SomeService serviceA_2) {
//        this.serviceA_2 = serviceA_2;
//    }


    //     setter inject
    @Autowired
    public void setService(SomeService serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public void service() {
        System.out.println(serviceA.getClass());

        System.out.println(serviceA_2.getClass());

        serviceA_2.service();
        System.out.println("Working!!!");
    }


}
