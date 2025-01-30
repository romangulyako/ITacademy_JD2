package itacademy.autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AddressAnnotation
public class AddressHome implements IAddress{
    private String id;
    private String city;
    private String street;
    private String house;
}
