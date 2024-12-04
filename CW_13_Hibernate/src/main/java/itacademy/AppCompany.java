package itacademy;

import itacademy.entity.Address;
import itacademy.entity.Company;
import itacademy.utils.HibernateUtils;

import javax.persistence.EntityManager;

public class AppCompany {
    public static void main(String[] args) {
        EntityManager em = HibernateUtils.getEntityManager();


        Company company = Company.builder()
                .homeAddress(Address.builder()
                        .city("Minsk")
                        .street("Независимости")
                        .zipcode("111")
                        .build())
                .billingAddress(Address.builder()
                        .city("Minsk")
                        .street("Дзержинского")
                        .zipcode("222")
                        .build())
                .name("Company")
                .build();

        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();

        em.close();
    }
}
