package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;

import java.sql.SQLException;
import java.util.List;

interface PaymentsService {
    List<Payment> getPayments() throws SQLException;

    PaymentCreateDto savePayment(PaymentCreateDto payment) throws SQLException;

    Payment findPaymentById(int id) throws SQLException;

    Payment updatePayment(PaymentCreateDto payment, int id) throws SQLException;

    String deletePayment(int id) throws SQLException;
}