package itacademy.spring_hibernate;

import itacademy.spring_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("appSpringHibernate")
public class AppSpringHibernate {
    @Autowired
    private final BaseDao<Employee> employeeBaseDao = new BaseDao<>();

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AppSpringHibernate appSpringHibernate = context.getBean("appSpringHibernate", AppSpringHibernate.class);

        Employee employee = new Employee();
        employee.setFirstName("Roman");
        employee.setLastName("Gulyako");
        appSpringHibernate.employeeBaseDao.setClazz(Employee.class);

        employee = appSpringHibernate.employeeBaseDao.save(employee);
        Employee foundEmployee = appSpringHibernate.employeeBaseDao.get(employee.getId());

        System.out.println(foundEmployee.getId() + ". " + foundEmployee.getFirstName());

        ((ClassPathXmlApplicationContext)context).close();
    }
}
