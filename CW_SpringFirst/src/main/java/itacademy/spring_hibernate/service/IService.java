package itacademy.spring_hibernate.service;

import java.io.Serializable;

public interface IService<T> {
    T save(T t);
    T update(T t);
    T get(Serializable id);
    void delete(Serializable id);
}
