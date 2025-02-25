package itacademy.springboottask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterData {
    private int page = 0;
    private int size = 2;
    private String name;
    private String type;
    private Integer age;
}
