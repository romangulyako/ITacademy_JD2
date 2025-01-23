package itacademy;
import itacademy.autowired.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        /*SenderService senderService = context.getBean("serviceSender", SenderService.class);
        senderService.send("Hello World");

        ISender sender = context.getBean("emailSender", ISender.class);
        System.out.println(sender.getAddress());

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getName());
        person.getEmailSender().send("Hello World");
        System.out.println(person.getEmailSender().getAddress());

        ConstructorBean constructorBean = context.getBean("constructorBean", ConstructorBean.class);

        System.out.println(constructorBean.getName());

        constructorBean.getMap().forEach((id, name) -> System.out.println(id + " " + name));

        constructorBean.getStringList().forEach(System.out::println);*/

        Person person = context.getBean("personAutowired", Person.class);
        System.out.println(person.getAddress());

        ((ClassPathXmlApplicationContext)context).close();
    }
}
