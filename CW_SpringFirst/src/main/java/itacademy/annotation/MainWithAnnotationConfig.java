package itacademy.annotation;

import itacademy.annotation.Person;
import itacademy.annotation.config.SecondConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MainWithAnnotationConfig /*implements BeanNameAware*/ {
    //private String beanName;
    private final PersonService personService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(NoXmlConfiguration.class);
        ctx.refresh();
        ctx.start();

        Person personAnnotation = ctx.getBean("annotationPerson", Person.class);
        System.out.println(personAnnotation);

        Person createSecondConfigPerson = ctx.getBean("createSecondConfigPerson", Person.class);
        System.out.println(createSecondConfigPerson);

        Person createPerson = ctx.getBean("createPerson", Person.class);
        System.out.println(createPerson);

        MainWithAnnotationConfig bean = ctx.getBean(MainWithAnnotationConfig.class);
        System.out.println(bean.personService.getPerson());
    }
}
