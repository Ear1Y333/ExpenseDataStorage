package mySpring.springPractice.Repository;

import mySpring.springPractice.Model.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryPaymentsDAO {
    private final List<Payment> PAYMENTS = new ArrayList<>();
    public List<Payment> getPayments() {
        return PAYMENTS;
    }

    public Payment savePayment(Payment payment) {
        PAYMENTS.add(payment);
        return payment;
    }


    public Payment findById(int user_id) {
        return PAYMENTS.stream().filter(el -> el.getId() == user_id).findFirst().orElse(null);
    }

    public Payment updatePayment(Payment payment) {
        int index = IntStream.range(0, PAYMENTS.size()).filter(el -> payment.getId() == PAYMENTS.get(el).getId()).findFirst().orElse(-1);
        if (index>-1){
            PAYMENTS.set(index, payment);
            return payment;
        }
        return null;
    }

    public void deletePayment(int id) {
        Payment payment = findById(id);
        if (payment != null) PAYMENTS.remove(findById(id));
    }
}
