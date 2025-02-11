package itacademy;

import itacademy.entity.Flower;
import itacademy.utils.HibernateUtils;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;

public class AppEntityManagerTest {
    public static EntityManager entityManager = HibernateUtils.getEntityManager();
    @Test
    public void persistTest(){
        Integer expectedId = 1;
        Flower flower = Flower.builder()
                        .name("Rose")
                                .age(1)
                                        .build();

        Flower returnFlower = AppEntityManager.persist(entityManager, flower);

        assertEquals(expectedId, returnFlower.getId());




    }
}
