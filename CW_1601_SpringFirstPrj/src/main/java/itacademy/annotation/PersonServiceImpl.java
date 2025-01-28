package itacademy.annotation;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person getPerson() {
        Person person = Person.builder()
                .id("6")
                .name("PersonService")
                .surname("SurnamePersonService")
                .build();
        System.out.println(person);
        return person;
    }
}
