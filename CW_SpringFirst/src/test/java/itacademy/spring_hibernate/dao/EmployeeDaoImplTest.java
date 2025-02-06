package itacademy.spring_hibernate.dao;

import itacademy.spring_hibernate.entity.Employee;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("classpath:SpringConfig.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class EmployeeDaoImplTest extends TestCase {
    @Autowired
    private EmployeeDao dao;

    @Test
    @Transactional
    @Rollback(false)
    public void addEmployee() {
        Employee employee = Employee.builder()
                .firstName("Roman")
                .lastName("Gulyako")
                .build();
        Employee savedEmployee = dao.save(employee);
        assertNotNull(savedEmployee.getId());
        savedEmployee = dao.get(savedEmployee.getId());
        assertEquals("Employee is not persisted", employee, savedEmployee);
    }

    @Test
    @Transactional
    public void deleteEmployee() {
        dao.delete(1);

        Employee employee = dao.get(1);
        assertNull(employee);
    }

}