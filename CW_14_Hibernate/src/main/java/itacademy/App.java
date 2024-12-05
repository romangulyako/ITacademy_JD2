package itacademy;

import itacademy.entity.Department;
import itacademy.entity.Employee;
import itacademy.entity.EmployeeDetails;
import itacademy.entity.Meeting;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        final Meeting meeting = Meeting.builder()
                .meetingDate(new Date(LocalDate.now().toEpochDay()))
                .subject("Event")
                .build();

        final Department department = Department.builder()
                .departmentName("Department Name")
                .build();

        final EmployeeDetails employeeDetails = EmployeeDetails.builder()
                .street("Независимости")
                .city("Minsk")
                .country("BLR")
                .state("ODKB")
                .build();

        Employee e = Employee.builder()
                .birthDate(new Date(LocalDate.now().toEpochDay()))
                .cellPhone("29-271-23-31")
                .firstName("Roman")
                .lastName("Gulyako")
                .employeeDetails(employeeDetails)
                .department(department)
                .meetings(Set.of(meeting))
                .build();

        employeeDetails.setEmployee(e);

        EntityManager em = HibernateUtils.getEntityManager();

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        EntityManager em2 = HibernateUtils.getEntityManager();
        em2.getTransaction().begin();
        Employee e2 = em2.find(Employee.class, e.getId());
        em2.getTransaction().commit();

        System.out.println(e2);
        System.out.println(e2.getEmployeeDetails());

        em.close();
        em2.close();
        HibernateUtils.close();

    }
}
