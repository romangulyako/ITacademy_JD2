package itacademy.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Data
@ToString(exclude = "person")
@EqualsAndHashCode(exclude = "person")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Passport {
    @Id
    @GenericGenerator(name = "one-one",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property",
                    value = "person"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "PERSON_ID")
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column
    private String series;

    @Column
    private Integer number;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Person person;
}
