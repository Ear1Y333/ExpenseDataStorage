import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteRequest{
    private Connection connection;

    private Statement statement;



    ExecuteRequest(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertValues(int family_member, int good, int amount, int unit_price, String purchase_date){
        String values = "%d, %d, %d, %d, '%s'".formatted(family_member, good, amount, unit_price, purchase_date);
        try {
            statement.execute("INSERT INTO Payments " + "(family_member, good, amount, unit_price, purchase_date) VALUES(" + values + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void getValues(){
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Payments");
            while (resultSet.next()){
                Payment payment = new Payment
                        (resultSet.getInt("payment_id"), resultSet.getInt("family_member"),
                                resultSet.getInt("good"), resultSet.getInt("amount"), resultSet.getInt("unit_price"), resultSet.getString("purchase_date"));
                System.out.println(payment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}