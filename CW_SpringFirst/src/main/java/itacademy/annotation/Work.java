package itacademy.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Work {
    @Pointcut("execution(* *.getPerson())")
    public void pointcutOne() {;
    }

    @Before("pointcutOne()")
    public void beforeWork() {
        System.out.println("We do before work");
    }

    @After("pointcutOne()")
    public void afterWork() {
        System.out.println("We do after work");
    }
}
