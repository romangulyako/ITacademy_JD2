package itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@DiscriminatorValue("E")
@DynamicInsert
@DynamicUpdate
public class Employee extends Person {
    private static final long serialVersionUID = 4L;
    private String company;
    private double salary;
}
