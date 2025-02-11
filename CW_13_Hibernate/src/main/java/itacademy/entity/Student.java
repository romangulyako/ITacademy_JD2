package itacademy.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
//@PrimaryKeyJoinColumn(name = "PERSON_ID")
//@DiscriminatorValue("S")
public class Student extends Person {
    private static final long serialVersionUID = 3L;

    @Column
    private String faculty;
    @Column
    private Double mark;
}
