package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;

import java.util.List;

interface PaymentsService {
     List<Payment> getPayments();
     PaymentCreateDto savePayment(PaymentCreateDto payment);
     Payment findPaymentById(int id);
     Payment updatePayment(PaymentCreateDto payment, int id);
     String deletePayment(int id);
}
