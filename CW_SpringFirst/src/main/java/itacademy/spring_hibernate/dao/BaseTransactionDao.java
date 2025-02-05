package itacademy.spring_hibernate.dao;

import itacademy.spring_hibernate.Dao;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class BaseTransactionDao<T> implements IDao<T> {
    private final Class<T> clazz;

    @Getter
    @PersistenceContext
    private EntityManager em;

    public BaseTransactionDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T save(T t) {
        getEm().persist(t);
        return t;

    }

    @Override
    public T update(T t) {
        getEm().merge(t);
        return t;
    }

    @Override
    public T get(Serializable id) {
        return getEm().find(clazz, id);
    }

    @Override
    public void delete(Serializable id) {
        T t = getEm().find(clazz, id);
        getEm().remove(t);
    }
}
