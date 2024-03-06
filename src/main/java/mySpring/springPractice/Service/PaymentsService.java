package mySpring.springPractice.Service;

import mySpring.springPractice.Model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

interface PaymentsService {
     List<Payment> getPayments();
     Payment savePayment(Payment payment);
     Payment findById(int id);
     Payment updatePayment(Payment payment);
     void deletePayment(int id);
}
