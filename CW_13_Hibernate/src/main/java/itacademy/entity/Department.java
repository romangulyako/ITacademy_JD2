package itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department extends DateEntity {
    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Employee> employees = new ArrayList<>(0);

}
