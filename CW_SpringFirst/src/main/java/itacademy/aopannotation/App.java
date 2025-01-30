package itacademy.aopannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        TaskService taskService = (TaskService) context.getBean("taskService", TaskService.class);
        taskService.performJob();
        try {
            taskService.performExceptionJob();
        } catch (Exception e) {}

        taskService.performJob("Roman");

        ((ClassPathXmlApplicationContext)context).close();
    }
}
