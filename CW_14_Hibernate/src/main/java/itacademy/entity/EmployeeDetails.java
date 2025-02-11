package itacademy.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString(exclude = "employee")
@EqualsAndHashCode(exclude = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GenericGenerator(name = "one-one",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property",
                    value = "employee"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "EMPLOYEE_ID")
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    //@Access(AccessType.PROPERTY)
    private Employee employee;
}
