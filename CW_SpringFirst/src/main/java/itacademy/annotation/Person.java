package itacademy.annotation;

import itacademy.autowired.IAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Component("annotationPerson")
public class Person {
    //@Value("#{'1'}")
    private String id;

    //@Value("#{'Petr'}")
    private String surname;

    //@Value("#{'Petrov'}")
    private String name;

    //@Value("#{addressAnnotation}")
    //@Autowired
    private IAddress address;
}
