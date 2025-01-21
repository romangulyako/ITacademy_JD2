package itacademy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        SenderService senderService = context.getBean("serviceSender", SenderService.class);
        senderService.send("Hello World");

        ISender sender = context.getBean("emailSender", ISender.class);
        System.out.println(sender.getAddress());
    }
}
