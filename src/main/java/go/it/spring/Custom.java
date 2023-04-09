package go.it.spring;

import org.springframework.aot.hint.annotation.Reflective;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Reflective
public @interface Custom {
    //... some meta info
}
