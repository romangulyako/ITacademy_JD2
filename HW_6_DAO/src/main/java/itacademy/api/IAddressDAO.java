package itacademy.api;

import itacademy.dto.Address;

import java.sql.SQLException;

public interface IAddressDAO extends DAO<Address> {
    boolean updateHouseOfLastFewAddresses(int countLastFewAddresses, int howMuchToIncreaseHouse) throws SQLException;
}
