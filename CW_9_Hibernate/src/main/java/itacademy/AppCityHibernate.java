package itacademy;

import itacademy.dto.entity.City;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;

public class AppCityHibernate {
    public static void main(String[] args) {
        City city = City.builder()
                .name("Minsk")
                .build();

        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        System.out.println(city);
        entityManager.close();
    }

}
