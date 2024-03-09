package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreate;

import java.util.List;

interface PaymentsService {
     List<Payment> getPayments();
     Payment savePayment(PaymentCreate payment);
     Payment findPaymentById(int id);
     Payment updatePayment(Payment payment);
     String deletePayment(int id);
}
