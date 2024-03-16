package mySpring.ExpenseDataSrorage.Connection;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class SQLConnection {
    @Bean
    public Connection getConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/family";
        final String USER = "root";
        final String PASSWORD = "fhDhf3r543fFDs";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}