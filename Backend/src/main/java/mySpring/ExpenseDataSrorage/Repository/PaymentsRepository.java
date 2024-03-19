package mySpring.ExpenseDataSrorage.Repository;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentsRepository {
    private static final String QUERY_TO_FIND_ALL = "SELECT * FROM Payments";
    private static final String QUERY_TO_INSERT_VALUES = "INSERT INTO Payments (family_member, good, amount, unit_price, purchase_date) VALUES(%d, %d, %d, %d, '%s')";
    private static final String QUERY_TO_FIND_BY_ID = "SELECT * FROM Payments WHERE payment_id = %d";
    private static final String QUERY_TO_UPDATE_BY_ID = "UPDATE Payments SET family_member = %d, good = %d, amount = %d, unit_price = %d, purchase_date = '%s' WHERE payment_id = %d";
    private static final String QUERY_TO_DELETE_BY_ID = "DELETE FROM Payments WHERE payment_id = %d";
    private static final String MESSAGE_FOR_UNSUCCESSFUL_DELETION = "No payment with id = %d";
    private static final String MESSAGE_FOR_SUCCESSFUL_DELETION = "Payment with id = %d was successfully deleted";

    private final Statement statement;

    public PaymentsRepository(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Payment> findAll() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_ALL);
        while (resultSet.next()) {
            Payment payment = new Payment
                    (resultSet.getInt("payment_id"), resultSet.getInt("family_member"),
                            resultSet.getInt("good"), resultSet.getInt("amount"), resultSet.getInt("unit_price"), resultSet.getString("purchase_date"));
            payments.add(payment);
        }
        return payments;
    }

    public PaymentCreateDto save(PaymentCreateDto payment) throws SQLException {
        statement.execute(QUERY_TO_INSERT_VALUES.formatted(payment.getFamilyMember(), payment.getGood(), payment.getAmount(), payment.getUnitPrice(), payment.getPurchaseDate()));
        return payment;
    }

    public Payment findById(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_BY_ID.formatted(id));
        if (resultSet.next()) {
            return new Payment(resultSet.getInt("payment_id"), resultSet.getInt("family_member"),
                    resultSet.getInt("good"), resultSet.getInt("amount"), resultSet.getInt("unit_price"), resultSet.getString("purchase_date"));
        }
        return null;
    }

    public Payment updateById(PaymentCreateDto payment, int id) throws SQLException {
        if (statement.executeUpdate(QUERY_TO_UPDATE_BY_ID.
                formatted(payment.getFamilyMember(), payment.getGood(), payment.getAmount(), payment.getUnitPrice(), payment.getPurchaseDate(), id)) != 0)
            return new Payment(id, payment);
        return null;
    }

    public String deleteById(int id) throws SQLException {
        if (statement.executeUpdate(QUERY_TO_DELETE_BY_ID.formatted(id)) != 0)
            return MESSAGE_FOR_SUCCESSFUL_DELETION.formatted(id);
        return MESSAGE_FOR_UNSUCCESSFUL_DELETION.formatted(id);
    }
}