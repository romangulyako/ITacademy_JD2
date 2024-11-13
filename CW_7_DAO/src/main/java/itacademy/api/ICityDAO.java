package itacademy.api;

import itacademy.dto.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends DAO<City> {
    List<City> getAll() throws SQLException;
    City getCitiesByName(String name) throws SQLException;
}
