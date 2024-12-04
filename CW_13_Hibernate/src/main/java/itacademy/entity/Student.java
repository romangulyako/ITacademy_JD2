package itacademy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table
@DiscriminatorValue("S")
public class Student extends Person {
    private static final long serialVersionUID = 3L;

    private String faculty;
    private Double mark;
}
