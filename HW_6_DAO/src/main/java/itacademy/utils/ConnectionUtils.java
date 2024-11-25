package itacademy.utils;

import itacademy.JDBCResources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
    }
}
