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
    private final String QUERY_TO_FIND_ALL_PAYMENTS = "SELECT * FROM Payments";
    private final String QUERY_TO_INSERT_VALUES = "INSERT INTO Payments (family_member, good, amount, unit_price, purchase_date) VALUES(%d, %d, %d, %d, '%s')";
    private final String QUERY_TO_FIND_BY_ID = "SELECT * FROM Payments WHERE payment_id = %d";
    private final String QUERY_TO_UPDATE_BY_ID = "UPDATE Payments SET family_member = %d, good = %d, amount = %d, unit_price = %d, purchase_date = '%s' WHERE payment_id = %d";
    private final String QUERY_TO_DELETE_BY_ID = "DELETE FROM Payments WHERE payment_id = %d";
    private final String MESSAGE_FOR_UNSUCCESSFUL_DELETION = "No payment with id = %d";
    private final String MESSAGE_FOR_SUCCESSFUL_DELETION = "Payment with id = %d was successfully deleted";
    private Connection connection = new SQLConnection().getConnection();
    private final Statement statement;

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
            ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_ALL_PAYMENTS);
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
    public PaymentCreate save(PaymentCreate payment){
        try {
            statement.execute(QUERY_TO_INSERT_VALUES.formatted(payment.getFamily_member(), payment.getGood(), payment.getAmount(), payment.getUnit_price(), payment.getPurchase_date()));
            return payment;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Payment findById(int id){
        try {
            ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_BY_ID.formatted(id));
            if(resultSet.next()){
                return new Payment(resultSet.getInt("payment_id"), resultSet.getInt("family_member"),
                        resultSet.getInt("good"), resultSet.getInt("amount"), resultSet.getInt("unit_price"), resultSet.getString("purchase_date"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Payment updateById(PaymentCreate payment, int id){
        try {
            if (statement.executeUpdate(QUERY_TO_UPDATE_BY_ID.
                    formatted(payment.getFamily_member(), payment.getGood(), payment.getAmount(), payment.getUnit_price(), payment.getPurchase_date(), id))==0)
                return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Payment(id, payment);
    }
    public String deleteById(int id){
        try {
            if (statement.executeUpdate(QUERY_TO_DELETE_BY_ID.formatted(id)) == 0) return MESSAGE_FOR_UNSUCCESSFUL_DELETION.formatted(id);

        } catch (SQLException e) {
            e.getErrorCode();
        }
        return MESSAGE_FOR_SUCCESSFUL_DELETION.formatted(id);
    }
}