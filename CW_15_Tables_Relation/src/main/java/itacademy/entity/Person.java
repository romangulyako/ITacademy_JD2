package itacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@ToString(exclude = "flats")
@EqualsAndHashCode(exclude = "flats")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Passport passport;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @ManyToMany(mappedBy = "persons")
    private Set<Flat> flats = new HashSet<>();
}
