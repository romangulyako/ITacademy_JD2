package itacademy;

import itacademy.dto.entity.Wheel;
import itacademy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class AppHibernate {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityManager entityManager2 = HibernateUtils.getEntityManager();


        Wheel wheel = Wheel.builder()
                .size("25")
                .type("Литые")
                .build();

        //persist(entityManager, wheel);

        /*find(entityManager);
        find(entityManager2);

        Wheel wheel3 = find(entityManager);

        entityManager.getTransaction().begin();
        wheel3.setSize("30");
        entityManager.merge(wheel3);
        entityManager.getTransaction().commit();

        find(entityManager);
        find(entityManager2);

        entityManager2.clear();
        find(entityManager2);*/



        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        Serializable id = session.save(Wheel.builder()
                .size("44")
                .type("Литые")
                .build());

        System.out.println("ID: " + id);



        Wheel wheel1 = session.get(Wheel.class, 3);
        System.out.println(wheel1);

        wheel1.setSize("45");
        session.update(wheel1);
        System.out.println(session.get(Wheel.class, 3));

        wheel1.setId(22);
        session.delete(wheel1);

        transaction.commit();

        entityManager.close();
        entityManager2.close();


        HibernateUtils.close();
    }

    private static Wheel find(EntityManager entityManager) {
        Wheel wheelEntity = entityManager.find(Wheel.class, 3);
        System.out.println(wheelEntity);
        return wheelEntity;
    }

    private static void persist(EntityManager entityManager, Wheel wheel) {
        entityManager.getTransaction().begin();
        entityManager.persist(wheel);
        entityManager.getTransaction().commit();
    }
}
