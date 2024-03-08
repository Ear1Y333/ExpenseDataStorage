package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;

import java.util.List;

interface PaymentsService {
     List<Payment> getPayments();
     Payment savePayment(PaymentCreateDto payment);
     Payment findById(int id);
     Payment updatePayment(Payment payment);
     void deletePayment(int id);
}
