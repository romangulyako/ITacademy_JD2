package itacademy.autowired;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@Data
public class Person {
    private String id;
    private String surname;
    private String name;
    //@Autowired
   // @Qualifier("addressValue")
    //@AddressAnnotation
    @Value("#{addressHome}")
    private IAddress address;
}
