package mySpring.ExpenseDataSrorage.Repository;

import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PaymentsRepository extends JpaRepository <Payment, Integer>{

    void deletePaymentById(int id);
    Payment findById(int id);
    default Payment savePayment(PaymentCreateDto payment) {
        return new Payment(1, payment.getFamily_member(), payment.getGood(), payment.getAmount(), payment.getUnit_price(), payment.getPurchase_date());
    }
}

