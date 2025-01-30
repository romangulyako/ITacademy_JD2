package itacademy;

public class Person {
    private static final Person person = new Person();
    private ISender emailSender;

    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person getInstance() {
        return person;
    }

    public ISender getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(ISender emailSender) {
        this.emailSender = emailSender;
    }

    public void init() {
        System.out.println("Initializing Person");
    }

    public void destroy() {
        System.out.println("Destroying Person");
    }
}
