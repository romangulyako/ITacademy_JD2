package itacademy.annotation;

import itacademy.annotation.config.SecondConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SecondConfig.class)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "itacademy.annotation")
public class NoXmlConfiguration {

    @Bean("createPerson")
    public Person createPerson() {
        return Person.builder()
                .id("3")
                .name("Person")
                .surname("Surname")
                .build();
    }
}
