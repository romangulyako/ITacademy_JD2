package itacademy.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE_1")
//@PrimaryKeyJoinColumn(name = "PERSON_ID")
//@DiscriminatorValue("E")
@DynamicInsert
@DynamicUpdate
public class Employee1 extends Person {
    private static final long serialVersionUID = 4L;

    @Column
    private String company;

    @Column
    private double salary;
}
