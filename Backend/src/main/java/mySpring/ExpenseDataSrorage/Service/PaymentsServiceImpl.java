package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import mySpring.ExpenseDataSrorage.Repository.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private final PaymentsRepository repository;

    public PaymentsServiceImpl(PaymentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment> getPayments() throws SQLException {
        return repository.findAll();
    }

    @Override
    public PaymentCreateDto savePayment(PaymentCreateDto payment) throws SQLException {
        return repository.save(payment);
    }

    @Override
    public Payment findPaymentById(int id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public Payment updatePayment(PaymentCreateDto payment, int id) throws SQLException {
        return repository.updateById(payment, id);
    }

    @Override
    public String deletePayment(int id) throws SQLException {
        return repository.deleteById(id);
    }
}