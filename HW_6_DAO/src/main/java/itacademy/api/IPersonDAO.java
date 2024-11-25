package itacademy.api;

import itacademy.dto.Person;

import java.sql.SQLException;

public interface IPersonDAO extends DAO<Person> {
    boolean updateAgeOfLastFewPersons(int countLastFewPersons, int howMuchToIncreaseAge) throws SQLException;
}
