import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        SQLConnection sqlConnection = new SQLConnection();
        ExecuteRequest executeRequest = new ExecuteRequest(SQLConnection.getConnection(), "INSERT");
    }
    private static class SQLConnection{
        private static final String URL = "jdbc:mysql://localhost:3306/family";
        private static final String USER = "root";
        private static final String PASSWORD = "fhDhf3r543fFDs";

        public static Connection getConnection(){
            try {
                return DriverManager.getConnection(URL, USER,PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class ExecuteRequest{
        private final Connection connection;
        private final String request;

        private ExecuteRequest(Connection connection, String request) {
            this.connection = connection;
            this.request = request;
        }
        public void doRequest(){
            try {
                Statement statement = connection.createStatement();

                statement.execute("");
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}