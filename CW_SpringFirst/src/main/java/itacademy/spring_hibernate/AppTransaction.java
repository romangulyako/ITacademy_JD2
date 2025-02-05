package itacademy.spring_hibernate;

import itacademy.spring_hibernate.entity.Employee;
import itacademy.spring_hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("appTransaction")
public class AppTransaction {
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AppTransaction appSpringHibernate = context.getBean("appTransaction", AppTransaction.class);

        Employee employee = new Employee();
        employee.setFirstName("Roman");
        employee.setLastName("Gulyako");
        //appSpringHibernate.employeeService.setClazz(Employee.class);

        employee = appSpringHibernate.employeeService.save(employee);
        Employee foundEmployee = appSpringHibernate.employeeService.get(employee.getId());

        System.out.println(foundEmployee.getId() + ". " + foundEmployee.getFirstName());

        ((ClassPathXmlApplicationContext)context).close();
    }
}
