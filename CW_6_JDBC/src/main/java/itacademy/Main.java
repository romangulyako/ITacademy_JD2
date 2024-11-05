package itacademy;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
             Statement statement = connection.createStatement()) {


            String query = "INSERT INTO lesson_5.cities (name) values ('Барселона')";
            statement.executeUpdate(query);

            query = "select * from lesson_5.cities";
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    System.out.print(resultSet.getString(1) + "|");
                    System.out.println(resultSet.getString(2));
                }

                ResultSetMetaData metaData = resultSet.getMetaData();
            }

            query = "INSERT INTO lesson_5.cities (name) values ('Клецк')";
            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
