package itacademy.annotation.config;

import itacademy.annotation.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConfig {

    @Bean("createSecondConfigPerson")
    public Person createPerson() {
        return Person.builder()
                .id("4")
                .surname("Surname2")
                .name("Person2")
                .build();
    }
}
