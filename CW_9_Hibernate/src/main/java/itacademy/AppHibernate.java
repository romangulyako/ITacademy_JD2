package itacademy;

import itacademy.dto.entity.Wheel;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;

public class AppHibernate {
    public static void main(String[] args) {
        Wheel wheel = Wheel.builder()
                .size("20")
                .type("Литые")
                .build();

        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(wheel);
        entityManager.getTransaction().commit();
        entityManager.close();

        EntityManager entityManager2 = HibernateUtils.getEntityManager();
        entityManager2.getTransaction().begin();
        Wheel wheelEntity = entityManager2.find(Wheel.class, 1);
        System.out.println(wheelEntity);
        entityManager2.remove(wheelEntity);
        entityManager2.getTransaction().commit();
        entityManager2.close();

        HibernateUtils.close();
    }
}
