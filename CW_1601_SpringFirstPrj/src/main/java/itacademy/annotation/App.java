package itacademy.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        Person person = (Person) context.getBean("annotationPerson");
        System.out.println(person.getAddress());

        ((ClassPathXmlApplicationContext)context).close();
    }
}
