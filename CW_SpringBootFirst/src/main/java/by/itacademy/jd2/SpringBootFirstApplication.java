package by.itacademy.jd2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFirstApplication.class, args);
    }

}
