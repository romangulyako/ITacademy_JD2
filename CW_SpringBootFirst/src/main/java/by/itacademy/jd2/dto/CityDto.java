package by.itacademy.jd2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private Integer id;
    @NotBlank(message = "Name can't be empty")
    private String name;
    @NotBlank(message = "Location can't be empty")
    private String location;
}
