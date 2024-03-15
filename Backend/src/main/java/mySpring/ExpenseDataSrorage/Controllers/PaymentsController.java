package mySpring.ExpenseDataSrorage.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import mySpring.ExpenseDataSrorage.Service.PaymentsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentsController {
    PaymentsServiceImpl service;

    @GetMapping
    public List<Payment> getPayments(){
        return service.getPayments();
    }
    @PostMapping("create")
    public PaymentCreateDto savePayment(@RequestBody PaymentCreateDto payment) {
        return service.savePayment(payment);
    }

    @GetMapping("{id}")
    public Payment findById(@PathVariable int id) {
        return service.findPaymentById(id);
    }
    @PutMapping("{id}")
    public Payment updatePayment(@RequestBody PaymentCreateDto payment, @PathVariable int id) {
        return service.updatePayment(payment, id);
    }
    @DeleteMapping("{id}")
    public String deletePayment(@PathVariable int id) {
        return service.deletePayment(id);
    }
}