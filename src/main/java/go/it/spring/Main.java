package go.it.spring;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> string = new ThreadLocal<>();

//        Map<ThreadId, SoveValue> threadLocal;
//
//        threadLocal.put(22,"Sub thread");
//        threadLocal.put(1,"Main thread");
//
//        SoveValue val =    threadLocal.get(1);

        SecurityContext context = SecurityContextHolder.getContext();

        string.set("Main thread " + Thread.currentThread().getId());

        new Thread(() -> {

            string.set("Sub thread " + Thread.currentThread().getId());
            System.out.println(string.get());

        }).start();

        Thread.sleep(1000);

        System.out.println(string.get());
    }
}
