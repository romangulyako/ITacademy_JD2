package itacademy.spring_hibernate.dao;

import itacademy.spring_hibernate.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends BaseTransactionDao<Employee> implements EmployeeDao {
    public EmployeeDaoImpl() {
        super(Employee.class);
    }
}
