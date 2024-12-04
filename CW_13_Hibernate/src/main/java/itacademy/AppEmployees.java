package itacademy;

import itacademy.entity.Employee;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;

public class AppEmployees {
    public static void main(String[] args) {
        EntityManager em = HibernateUtils.getEntityManager();

        Employee emp = new Employee();

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }
}
