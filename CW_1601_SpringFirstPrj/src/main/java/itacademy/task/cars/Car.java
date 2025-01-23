package itacademy.task.cars;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
public class Car {
    private String vin;
    private String model;
    private String type;
    @Autowired
    @Qualifier("defaultEngine")
    //@Value("#{petrolCar}")
    private IEngine engine;
}
