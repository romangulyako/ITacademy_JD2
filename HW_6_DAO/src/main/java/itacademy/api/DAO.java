package itacademy.api;

import java.sql.SQLException;

public interface DAO<T> {
    Integer insert(T obj) throws SQLException;
    boolean deleteFirstFew(int count) throws SQLException;
}
