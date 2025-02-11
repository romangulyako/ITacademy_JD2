package itacademy.task.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        HRService hrService = context.getBean("hrService", HRService.class);

        hrService.findEmployee("JAVA");

        ((ClassPathXmlApplicationContext)context).close();
    }
}
