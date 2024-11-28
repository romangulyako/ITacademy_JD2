package itacademy;

import itacademy.entity.Flower;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;

public class AppEntityManager {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtils.getEntityManager();

        /*persist(entityManager);

        find(entityManager);

        remove(entityManager);*/

        System.out.println(persist(entityManager,
                Flower.builder()
                        .name("Rose")
                        .age(2)
                        .build()));


        entityManager.close();

        HibernateUtils.close();
    }

    private static void find(EntityManager entityManager) {
        Flower flower = entityManager.find(Flower.class, 3);
        System.out.println(flower);
    }

    private static void remove(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Flower.class, 4));
        entityManager.getTransaction().commit();
    }

    private static void persist(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        for (int i = 0; i < 5; i++) {
            Flower flower = Flower.builder()
                    .name("Flower " + i)
                    .age(i + 1)
                    .build();

            entityManager.persist(flower);
        }
        entityManager.getTransaction().commit();
    }

    public static Flower persist(EntityManager entityManager, Flower flower) {
        entityManager.getTransaction().begin();
        entityManager.persist(flower);
        entityManager.getTransaction().commit();

        return flower;
    }
}
