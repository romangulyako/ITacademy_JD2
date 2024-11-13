package itacademy.dao;

import itacademy.api.IAddressDAO;
import itacademy.api.SQLExecutor;
import itacademy.dto.Address;
import itacademy.utils.ExecutorUtils;

import java.sql.*;


public class AddressDAO implements IAddressDAO {

    private static final String INSERT_ADDRESS = "INSERT INTO address (street, house) VALUES (?, ?)";
    private static final String DELETE_FIRST_FEW_ADDRESSES = "DELETE FROM address LIMIT ?";
    private static final String UPDATE_HOUSE_LAST_FEW_ADDRESSES = "update address as a " +
            "join (select  id from address ORDER BY id DESC limit ?) as latest " +
            "on a.id = latest.id set a.house = a.house + ?";

    @Override
    public Integer insert(Address obj) throws SQLException {
        SQLExecutor<Integer> sqlExecutor = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, obj.getStreet());
            preparedStatement.setInt(2, obj.getHouse());

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
    public boolean deleteFirstFew(int count) throws SQLException {
        SQLExecutor<Boolean> sqlExecutor = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FIRST_FEW_ADDRESSES);
            preparedStatement.setInt(1, count);

            return preparedStatement.executeUpdate() > 0;
        };

        return ExecutorUtils.executeSQL(sqlExecutor);
    }

    @Override
    public boolean updateHouseOfLastFewAddresses(int countLastFewAddresses, int howMuchToIncreaseHouse) throws SQLException {
        SQLExecutor<Boolean> sqlExecutor = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOUSE_LAST_FEW_ADDRESSES);
            preparedStatement.setInt(1, countLastFewAddresses);
            preparedStatement.setInt(2, howMuchToIncreaseHouse);

            return preparedStatement.executeUpdate() > 0;
        };

        return ExecutorUtils.executeSQL(sqlExecutor);
    }
}
