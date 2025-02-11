package itacademy;

import itacademy.entity.Address;
import itacademy.entity.Flat;
import itacademy.entity.Passport;
import itacademy.entity.Person;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Passport passport = Passport.builder()
                .series("MC")
                .number(123456)
                .build();

        Address address = Address.builder()
                .city("Minsk")
                .street("Nezavisimosti")
                .houseNumber(1)
                .build();

        Person person = Person.builder()
                .name("Roman")
                .surname("Gulyako")
                .patronymic("Sergeevich")
                .passport(passport)
                .build();

        passport.setPerson(person);

        Flat flat = Flat.builder()
                .hight(2.7)
                .stage(19)
                .address(address)
                .persons(Set.of(person))
                .build();

        person.setFlats(Set.of(flat));

        EntityManager em = HibernateUtils.getEntityManager();

        em.getTransaction().begin();
        em.persist(flat);
        em.getTransaction().commit();

        em.close();
        HibernateUtils.close();
    }
}
