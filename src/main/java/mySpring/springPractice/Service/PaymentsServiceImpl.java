package mySpring.springPractice.Service;

import lombok.AllArgsConstructor;
import mySpring.springPractice.Model.Payment;
import mySpring.springPractice.Repository.InMemoryPaymentsDAO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service

public class PaymentsServiceImpl implements PaymentsService{
    InMemoryPaymentsDAO repository;
    @Override
    public List<Payment> getPayments() {
        return repository.getPayments();
    }

    @Override
    public Payment savePayment(Payment payment) {
        return repository.savePayment(payment);
    }

    @Override
    public Payment findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return repository.updatePayment(payment);
    }

    @Override
    public void deletePayment(int id) {
        repository.deletePayment(id);
    }
}
