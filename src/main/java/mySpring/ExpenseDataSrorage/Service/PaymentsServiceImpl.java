package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreate;
import mySpring.ExpenseDataSrorage.Repository.PaymentsRepository;
import org.springframework.stereotype.Service;
import mySpring.ExpenseDataSrorage.Connection.SQLConnection;

import java.util.List;
@Service

public class PaymentsServiceImpl implements PaymentsService{

    PaymentsRepository repository = new PaymentsRepository();
    @Override
    public List<Payment> getPayments() {
        return repository.findAll();
    }

    @Override
    public PaymentCreate savePayment(PaymentCreate payment) {
        return repository.save(payment);
    }

    @Override
    public Payment findPaymentById(int id) {
        return repository.findById(id);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return repository.updateById(payment);
    }

    @Override
    public String deletePayment(int id) {
        return repository.deleteById(id);
    }
}