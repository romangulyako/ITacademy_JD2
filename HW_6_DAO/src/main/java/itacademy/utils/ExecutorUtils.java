package itacademy.utils;

import itacademy.api.SQLExecutor;

import java.sql.Connection;
import java.sql.SQLException;

public class ExecutorUtils {
    public static  <T> T executeSQL(SQLExecutor<T> sqlExecutor) {
        try (Connection connection = ConnectionUtils.getConnection()) {
            return sqlExecutor.execute(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
