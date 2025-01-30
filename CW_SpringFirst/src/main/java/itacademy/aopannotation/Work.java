package itacademy.aopannotation;

import itacademy.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Work {
    @Pointcut("execution(* itacademy.aopannotation.TaskService.performJob())")
    public void performance() {}

    @Pointcut("execution(* itacademy.aopannotation.TaskService.performExceptionJob())")
    public void performanceException() {}

    @Pointcut("execution(* itacademy.aopannotation.TaskService.performJob(String)) && args(name)")
    public void intercept(String name) {}

    @Before("performance()")
    public void beforeWork() {
        System.out.println("Execution before work");
    }

    @AfterReturning("performance()")
    public void afterWork() {
        System.out.println("Execution after work");
    }

    @AfterThrowing("performanceException()")
    public void afterThrowingWork() {
        System.out.println("Execution after throwing work");
    }

    @Around("performance()")
    public void aroundWork(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("start");
            System.out.println("time start: " + System.currentTimeMillis());
            joinPoint.proceed();
            System.out.println("time end: " + System.currentTimeMillis());
            System.out.println("end");
        } catch (Throwable e) {}
    }

    @Before("intercept(name)")
    public void interceptWork(String name) {
        name = "new name";
        System.out.println("Name: " + name);
    }
}
