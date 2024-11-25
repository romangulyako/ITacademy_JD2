package itacademy.dao;

import itacademy.api.IPersonDAO;
import itacademy.api.SQLExecutor;
import itacademy.dto.Person;
import itacademy.utils.ExecutorUtils;

import java.sql.*;

public class PersonDAO implements IPersonDAO {
    private static final String INSERT_PERSON = "INSERT INTO people (name, surname, age) VALUES (?, ?, ?)";
    private static final String DELETE_FIRST_FEW_PERSONS = "DELETE FROM people LIMIT ?";
    private static final String UPDATE_AGE_LAST_FEW_PERSONS = "update people as p " +
            "join (select  id from people ORDER BY id DESC limit ?) as latest " +
            "on p.id = latest.id set p.age = p.age + ?";

    @Override
    public Integer insert(Person obj) throws SQLException {
        SQLExecutor<Integer> sqlExecutor = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getSurname());
            preparedStatement.setInt(3, obj.getAge());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException();
                }
            }
        };

        return ExecutorUtils.executeSQL(sqlExecutor);
    }

    @Override
    public boolean updateAgeOfLastFewPersons(int countLastFewPersons, int howMuchToIncreaseAge) throws SQLException {

        SQLExecutor<Boolean> sqlExecutor = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AGE_LAST_FEW_PERSONS);
            preparedStatement.setInt(1, countLastFewPersons);
            preparedStatement.setInt(2, howMuchToIncreaseAge);

            return preparedStatement.executeUpdate() > 0;
        };

        return ExecutorUtils.executeSQL(sqlExecutor);
    }

    @Override
    public boolean deleteFirstFew(int count) throws SQLException {

        SQLExecutor<Boolean> sqlExecutor = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FIRST_FEW_PERSONS);
            preparedStatement.setInt(1, count);

            return preparedStatement.executeUpdate() > 0;
        };

        return ExecutorUtils.executeSQL(sqlExecutor);
    }
}
