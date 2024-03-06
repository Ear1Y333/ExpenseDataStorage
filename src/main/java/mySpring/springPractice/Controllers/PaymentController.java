package mySpring.springPractice.Controllers;

import lombok.AllArgsConstructor;
import mySpring.springPractice.Model.Payment;
import mySpring.springPractice.Service.PaymentsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {
    PaymentsServiceImpl paymentsService;

    @GetMapping
    public List<Payment> getPayments(){
        return paymentsService.getPayments();
    }
    @PostMapping("save_payment")
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentsService.savePayment(payment);
    }
    @GetMapping("/{id}")
    public Payment findById(@PathVariable int id) {
        return paymentsService.findById(id);
    }
    @PutMapping("update_payment")
    public Payment updatePayment(@RequestBody Payment payment) {
        return paymentsService.updatePayment(payment);
    }
    @DeleteMapping("delete_payment/{id}")
    public void deletePayment(@PathVariable int id) {
        paymentsService.deletePayment(id);
    }
}
