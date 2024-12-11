package itacademy;

import itacademy.entity.HomeTask;
import itacademy.entity.Task;
import itacademy.entity.WorkTask;
import itacademy.entity.embeddable.Address;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;

public class AppTask {
    public static void main(String[] args) {
        HomeTask homeTask = HomeTask.builder()
                .name("ДЗ 7")
                .description("Работа с Hibernate")
                .startDate(new Date(LocalDate.now().toEpochDay()))
                .endDate(new Date(LocalDate.now().toEpochDay()))
                .address(Address.builder()
                        .city("Минск")
                        .street("Героев 120-й дивизии")
                        .build())
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("Работа на занятии")
                .description("Изучение Hibernate")
                .cost(2.20)
                .build();

        Task task = Task.builder()
                .name("Пустая работа")
                .description("Пустое описание")
                .build();

        EntityManager em = HibernateUtils.getEntityManager();

        em.getTransaction().begin();
        em.persist(homeTask);
        em.persist(workTask);
        em.persist(task);
        em.getTransaction().commit();

        em.close();
        HibernateUtils.close();
    }
}
