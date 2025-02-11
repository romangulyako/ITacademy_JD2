package itacademy.spring_hibernate.repository;

import itacademy.spring_hibernate.entity.Employee;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("classpath:SpringConfig.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryTest extends TestCase {
    @Autowired
    private EmployeeRepository repository;

    @Test
    public void employeeAdd() {
        Employee employee = Employee.builder()
                .firstName("Roman")
                .lastName("Gulyako")
                .build();
        repository.save(employee);

        List<Employee> employeesByLastName = repository.findByFirstNameAndLastName("Roman", "Gulyako");
        employeesByLastName.forEach(System.out::println);


        Iterable<Employee> employees = repository.findAll();
        //employees.forEach(System.out::println);
        assertEquals(1, repository.count());
    }
}