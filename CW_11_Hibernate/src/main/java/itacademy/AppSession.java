package itacademy;

import itacademy.entity.Flower;
import org.hibernate.Session;
import itacademy.utils.HibernateUtils;
import org.hibernate.Transaction;

public class AppSession {
    public static void main(String[] args) {
        Session session = HibernateUtils.getEntityManager().unwrap(Session.class);

        save(session);

        System.out.println(get(session));

        delete(session);

        session.close();
        HibernateUtils.close();
    }

    private static void delete(Session session) {
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Flower.class, 4));
        transaction.commit();
    }

    private static Flower get(Session session) {
        return session.get(Flower.class, 3);
    }

    private static void save(Session session) {
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 5; i++) {
            Flower flower = Flower.builder()
                    .name("Flower " + i)
                    .age(i + 1)
                    .build();

            session.save(flower);
        }
        transaction.commit();
    }

    private static Flower save(Session session, Flower flower) {
        Transaction transaction = session.beginTransaction();
        session.save(flower);
        transaction.commit();

        return flower;
    }
}
