package itacademy;

import itacademy.entity.Employee;
import itacademy.entity.Meeting;
import itacademy.entity.wrappers.FIO;
import itacademy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppCW_16 {
    public static void main(String[] args) {
        EntityManager em = HibernateUtils.getEntityManager();

        Query query = em.createQuery(
                "SELECT e.firstName, count(e.firstName) " +
                        "FROM Employee e " +
                        "GROUP BY e.firstName");

        query.getResultList().forEach(ems -> {
            Object[] emp = (Object[]) ems;
            System.out.println("Name: " + emp[0] + ", count: " + emp[1]);
        });

        query = em.createQuery(
                "FROM Employee e " +
                "WHERE e.firstName = :firstName");
        query.setParameter("firstName", "Roman");

        query.getResultList().forEach(System.out::println);

        em.getTransaction().begin();
        Query query1 = em.createQuery(
                "FROM Employee e "
                        + "WHERE e.id = :id ");
        query1.setParameter("id", 1);
        List<Employee> resultList = query1.getResultList();
        resultList.forEach(System.out::println);
        em.getTransaction().commit();

        EntityManager em2 = HibernateUtils.getEntityManager();
        em2.getTransaction().begin();
        Meeting meeting = em2.find(Meeting.class, 3);
        meeting.setSubject("NEW SUBJECT");
        em2.merge(meeting);
        em2.getTransaction().commit();

        em.getTransaction().begin();
        Employee employee = em2.find(Employee.class, 1);
        employee.setFirstName("Roman");
        em.merge(employee);
        em.getTransaction().commit();

        resultList.forEach(emp -> System.out.println(emp + " {" + emp.getMeetings() + "}"));

        em.getTransaction().begin();
        Query query2 = em.createQuery(
                "FROM Employee e where e.id in(:id) ");
        List resultList2 = query2.setParameter("id", Stream.of(1, 7).collect(Collectors.toList()))
                .getResultList();

        resultList2.forEach(System.out::println);
        em.getTransaction().commit();

        Session session = em.unwrap(Session.class);
        List<FIO> fioList = session.createSQLQuery("select e.first_name as firstName," +
                        "e.last_name as lastName from employee e")
                .addScalar("firstName", StandardBasicTypes.STRING)
                .addScalar("LastName", StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(FIO.class)).list();

        fioList.forEach(System.out::println);

        em.close();
        HibernateUtils.close();
    }
}
