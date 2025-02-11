package itacademy;

import itacademy.dto.entity.Wheel;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;

public class LifeTimeSessionApp {
    public static void main(String[] args) {
        EntityManager em = HibernateUtils.getEntityManager();

        addWheel(em);

        //Wheel wheel = em.getReference(Wheel.class, 2);
        Wheel wheel = em.find(Wheel.class, 1);
        System.out.println(wheel);

        em.close();
    }

    private static void addWheel(EntityManager entityManager) {
        Wheel wheel = Wheel.builder()
                .size("55")
                .type("Колесо")
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(wheel);
        entityManager.getTransaction().commit();

        System.out.println(wheel);
    }


}
