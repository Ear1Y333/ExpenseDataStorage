package mySpring.ExpenseDataSrorage.Service;

import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import mySpring.ExpenseDataSrorage.Repository.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service

public class PaymentsServiceImpl implements PaymentsService{
    PaymentsRepository repository;
    @Override
    public List<Payment> getPayments() {
        System.out.println();
        return repository.findAll();
    }

    @Override
    public Payment savePayment(PaymentCreateDto payment) {
        return repository.savePayment(payment);
    }

    @Override
    public Payment findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public void deletePayment(int id) {
        repository.deletePaymentById(id);
    }
}