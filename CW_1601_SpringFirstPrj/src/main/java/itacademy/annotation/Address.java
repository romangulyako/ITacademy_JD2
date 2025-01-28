package itacademy.annotation;

import itacademy.autowired.IAddress;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@NoArgsConstructor
@Data
@Component("addressAnnotation")
public class Address  implements IAddress {
    @Value("#{'1'}")
    private String id;

    @Value("#{'Minsk'}")
    private String city;

    @Value("#{'Brovky'}")
    private String street;

    @Value("#{'23'}")
    private String house;
}
