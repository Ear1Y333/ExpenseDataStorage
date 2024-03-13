package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import mySpring.ExpenseDataSrorage.Repository.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PaymentsServiceImpl implements PaymentsService{

    private final PaymentsRepository repository;

    public PaymentsServiceImpl(PaymentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment> getPayments() {
        return repository.findAll();
    }

    @Override
    public PaymentCreateDto savePayment(PaymentCreateDto payment) {
        return repository.save(payment);
    }

    @Override
    public Payment findPaymentById(int id) {
        return repository.findById(id);
    }

    @Override
    public Payment updatePayment(PaymentCreateDto payment, int id) {
        return repository.updateById(payment, id);
    }

    @Override
    public String deletePayment(int id) {
        return repository.deleteById(id);
    }
}