package itacademy.dao;

import itacademy.JDBCResources;
import itacademy.api.ICityDAO;
import itacademy.dto.City;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements ICityDAO {
    public static final String SELECT_CITY_BY_NAME = "SELECT * FROM cities WHERE name = ?";
    public static final String SELECT_ALL_CITIES = "SELECT * FROM cities";
    public static final String INSERT_CITY = "INSERT INTO cities (name) VALUES (?)";
    public static final String UPDATE_CITY = "UPDATE cities SET name = ? WHERE id = ?";
    public static final String DELETE_CITY = "DELETE FROM cities WHERE id = ?";
    public static final String SELECT_CITY_BY_ID = "SELECT * FROM cities WHERE id = ?";

    @Override
    public List<City> getAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CITIES)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City city = new City();
                    city.setName(rs.getString("name"));
                    city.setId(rs.getInt("id"));
                    cities.add(city);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return cities;
    }

    @Override
    public City getCitiesByName(String name) throws SQLException {
        City city = new City();
        try (Connection conn = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
        PreparedStatement ps = conn.prepareStatement(SELECT_CITY_BY_NAME)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    city.setId(rs.getInt("id"));
                    city.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw e;
        }

        return city;
    }

    @Override
    public City save(City city) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
             PreparedStatement ps = conn.prepareStatement(INSERT_CITY, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, city.getName());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    city.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw e;
        }

        return city;
    }

    @Override
    public City get(Serializable id) throws SQLException {
        City city = new City();
        try (Connection conn = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
             PreparedStatement ps = conn.prepareStatement(SELECT_CITY_BY_ID)) {

            ps.setInt(1, (Integer) id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    city.setId(rs.getInt("id"));
                    city.setName(rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            throw e;
        }
        return city;
    }

    @Override
    public void update(City city) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
             PreparedStatement ps = conn.prepareStatement(UPDATE_CITY)) {

            ps.setString(1, city.getName());
            ps.setInt(2, city.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
             PreparedStatement ps = conn.prepareStatement(DELETE_CITY, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, (Integer) id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

}
