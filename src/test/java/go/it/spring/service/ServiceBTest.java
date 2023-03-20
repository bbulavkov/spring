package go.it.spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ServiceBTest {

    private ServiceB serviceB;

    @BeforeEach
    void setUp() {
        ServiceA mock = mock(ServiceA.class);

        serviceB = new ServiceB(mock);

        serviceB.setService(null);
    }

    @AfterEach
    void tearDown() {
        serviceB = null;
    }

    @Test
    void service() {
        serviceB.service();
    }
}