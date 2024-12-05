package itacademy;

import itacademy.entity.Employee1;
import itacademy.entity.Person;
import itacademy.entity.Student;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;

public class AppPersons {
    public static void main(String[] args) {
        EntityManager em = HibernateUtils.getEntityManager();

        Employee1 emp = new Employee1();

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        Employee1 emp2 = Employee1.builder()
                .company("Oracle")
                .salary(1000)
                .build();

        em.getTransaction().begin();
        em.persist(emp2);
        em.getTransaction().commit();

        Student student = Student.builder()
                .mark(4.0)
                .faculty("faculty")
                .build();

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        Person person = Employee1.builder()
                .salary(5000)
                .build();

        person.setName("Roma");

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();


        Person person1 = Person.builder()
                .name("Name")
                .surname("surname")
                .build();

        em.getTransaction().begin();
        em.persist(person1);
        em.getTransaction().commit();

        Student student1 = Student.builder()
                .name("qweqw")
                .surname("vrfwrf")
                .mark(2.0)
                .faculty("eqweqwe")
                .build();

        em.getTransaction().begin();
        em.persist(student1);
        em.getTransaction().commit();


        em.close();
    }
}
