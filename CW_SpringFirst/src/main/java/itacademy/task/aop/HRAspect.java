package itacademy.task.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class HRAspect {
    @Pointcut("execution(* itacademy.task.aop.HRService.findEmployee(String)) && args(experience)")
    public void find(String experience) {}


    /*@Before("find(experience)")
    public void beforeFind(String experience) {
        System.out.println("Начат поиск");
        System.out.println("Время начала поиска: " + LocalDateTime.now());
    }

    @After("find(experience)")
    public void afterFind(String experience) {
        System.out.println("Поиск окончен");
        System.out.println("Experience: " + experience);
    }*/

    @Around("find(experience)")
    public void aroundFind(ProceedingJoinPoint joinPoint, String experience) throws Throwable {
        System.out.println("Начат поиск");
        System.out.println("Время начала поиска: " + LocalDateTime.now());
        joinPoint.proceed();
        System.out.println("Поиск окончен");
        System.out.println("Experience: " + experience);
    }
}
