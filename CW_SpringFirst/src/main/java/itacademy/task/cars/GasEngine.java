package itacademy.task.cars;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GasEngine implements IEngine{
    private double volume;
    private Integer cylindersCount;
    private String manufacturer;
}
