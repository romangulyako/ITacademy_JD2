package itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    private String id;
    private String name;
    private String age;
    private String address;
    private String mark;
}
