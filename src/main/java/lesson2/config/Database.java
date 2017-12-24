package lesson2.config;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/miracle";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    /**
     * @return connection to database miracle.
     */
    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
