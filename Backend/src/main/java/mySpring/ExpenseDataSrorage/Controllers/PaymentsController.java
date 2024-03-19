package mySpring.ExpenseDataSrorage.Controllers;

import lombok.RequiredArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import mySpring.ExpenseDataSrorage.Service.PaymentsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentsController {
    private final PaymentsServiceImpl service;

    @GetMapping
    public List<Payment> getPayments() {
        try {
            return service.getPayments();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("create")
    public PaymentCreateDto savePayment(@RequestBody PaymentCreateDto payment) {
        try {
            return service.savePayment(payment);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public Payment findById(@PathVariable int id) {
        try {
            return service.findPaymentById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("{id}")
    public Payment updatePayment(@RequestBody PaymentCreateDto payment, @PathVariable int id) {
        try {
            return service.updatePayment(payment, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("{id}")
    public String deletePayment(@PathVariable int id) {
        try {
            return service.deletePayment(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}