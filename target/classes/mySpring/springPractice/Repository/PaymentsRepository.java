package mySpring.ExpenseDataSrorage.Repository;

import mySpring.ExpenseDataSrorage.Connection.SQLConnection;
import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PaymentsRepository {
    private Connection connection = new SQLConnection().getConnection();
    private Statement statement;

    public PaymentsRepository() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Payment> findAll(){
        try {
            ArrayList<Payment> payments = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Payments");
            while (resultSet.next()){
                Payment payment = new Payment
                        (resultSet.getInt("payment_id"), resultSet.getInt("family_member"),
                                resultSet.getInt("good"), resultSet.getInt("amount"), resultSet.getInt("unit_price"), resultSet.getString("purchase_date"));
                payments.add(payment);
            }
            return payments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Payment save(PaymentCreate payment){
        String values = "%d, %d, %d, %d, '%s'".formatted(payment.getFamily_member(), payment.getGood(), payment.getAmount(), payment.getUnit_price(), payment.getPurchase_date());
        try {
            statement.execute("INSERT INTO Payments " + "(family_member, good, amount, unit_price, purchase_date) VALUES(" + values + ")");
           
            return new Payment(1, payment.getFamily_member(), payment.getGood(), payment.getAmount(), payment.getUnit_price(), payment.getPurchase_date());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Payment findById(int id){
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Payments WHERE payment_id = " + id);
            if(resultSet.next()){
                return new Payment(resultSet.getInt("payment_id"), resultSet.getInt("family_member"),
                        resultSet.getInt("good"), resultSet.getInt("amount"), resultSet.getInt("unit_price"), resultSet.getString("purchase_date"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Payment updateById(Payment payment){
        String value = String.format("family_member = %d, good = %d, amount = %d, unit_price = %d, purchase_date = '%s'",payment.getFamily_member(), payment.getGood(), payment.getAmount(), payment.getUnit_price(), payment.getPurchase_date());
        try {
            statement.execute("UPDATE Payments SET " + value + " WHERE payment_id = " + payment.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return payment;
    }
    public String deleteById(int id){
        try {
            String query = "DELETE FROM Payments WHERE payment_id = " + String.valueOf(id);
            if (statement.executeUpdate(query) == 0) return "Removal failed";

        } catch (SQLException e) {
            e.getErrorCode();
        }
        return "Payment with id = " + id + " had deleted";
    }
}