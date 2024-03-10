package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreate;

import java.util.List;

interface PaymentsService {
     List<Payment> getPayments();
     PaymentCreate savePayment(PaymentCreate payment);
     Payment findPaymentById(int id);
     Payment updatePayment(PaymentCreate payment, int id);
     String deletePayment(int id);
}
