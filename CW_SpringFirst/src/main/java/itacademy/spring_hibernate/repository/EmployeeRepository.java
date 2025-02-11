package itacademy.spring_hibernate.repository;

import itacademy.spring_hibernate.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
