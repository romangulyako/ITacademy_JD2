package itacademy;

import itacademy.dto.entity.Wheel;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class App {
    public static void main(String[] args) {

        EntityManager em = HibernateUtils.getEntityManager();

        Wheel wheel = Wheel.builder()
                .size("22")
                .type("Обычное")
                .build();

        em.getTransaction().begin();
        em.persist(wheel);
        em.getTransaction().commit();




        System.out.println(wheel);


        List<Wheel> list = em.createQuery("from Wheel", Wheel.class).getResultList();
        //List<Wheel> list = em.createQuery("select w from wheel w").getResultList();

        for (Wheel wheel1 : list) {
            System.out.println(wheel1);
        }

        Wheel wheel3 = Wheel.builder()
                .id(5)
                .size("25")
                .type("Необычное")
                .build();

        em.getTransaction().begin();
        em.merge(wheel3);
        em.getTransaction().commit();

        em.clear();
        System.out.println(em.find(Wheel.class, 5));


        em.close();

    }
}
