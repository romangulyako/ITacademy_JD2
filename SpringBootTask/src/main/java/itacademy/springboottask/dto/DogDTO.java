package itacademy.springboottask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDTO {
    private Long id;
    private String name;
    private String type;
    private Integer age;
}
