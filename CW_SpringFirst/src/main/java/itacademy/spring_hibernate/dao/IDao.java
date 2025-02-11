package itacademy.spring_hibernate.dao;

import java.io.Serializable;

public interface IDao<T> {
    T save(T t);
    T update(T t);
    T get(Serializable id);
    void delete(Serializable id);
}
