package itacademy;

import itacademy.dao.CityDAO;
import itacademy.dto.City;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CityDAO cityDAO = new CityDAO();

        try {
            City city = cityDAO.getCitiesByName("Минск");

            printCity(city);

            city = cityDAO.get(5);
            printCity(city);

            city.setName("Рио-де-Жанейро");
            cityDAO.update(city);
            printCity(city);

            city.setName("Клецк");
            City newCity = cityDAO.save(city);
            printCity(newCity);

            int id = cityDAO.delete(10);
            System.out.println(id);

            List<City> cities = cityDAO.getAll();
            for (City c : cities) {
                printCity(c);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printCity(City city) {
        System.out.println(city.getId());
        System.out.println(city.getName());
    }
}
