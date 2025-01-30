package itacademy.aop;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;

@Getter
@Setter
public class Notification {
    private  String name;

    public void notifyBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start: " + System.currentTimeMillis());
        joinPoint.proceed();
        System.out.println("end: " + System.currentTimeMillis());
    }

    public void notifyAfter() {
        System.out.println("Notify after");
    }
}
