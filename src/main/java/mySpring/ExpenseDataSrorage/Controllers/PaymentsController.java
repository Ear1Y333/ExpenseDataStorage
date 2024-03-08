package mySpring.ExpenseDataSrorage.Controllers;

import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.Payment;
import mySpring.ExpenseDataSrorage.Model.PaymentCreateDto;
import mySpring.ExpenseDataSrorage.Service.PaymentsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentsController {
    PaymentsServiceImpl paymentsService;

    @GetMapping
    public List<Payment> getPayments(){
        return paymentsService.getPayments();
    }
    @PostMapping("create")
    public Payment savePayment(@RequestBody PaymentCreateDto payment) {
        return paymentsService.savePayment(payment);
    }

    @GetMapping("{id}")
    public Payment findById(@PathVariable int id) {
        return paymentsService.findById(id);
    }
    @PutMapping("{id}")
    public Payment updatePayment(@RequestBody Payment payment, @PathVariable int id) {
        return paymentsService.updatePayment(payment);
    }
    @DeleteMapping("{id}")
    public String deletePayment(@PathVariable int id) {
        paymentsService.deletePayment(id);
        return ("FUCK");
        //TODO ПИСАТЬ СООБЩЕНИЕ ТОЛЬКО ЕСЛИ УДАЛЯЕТСЯ
    }
}