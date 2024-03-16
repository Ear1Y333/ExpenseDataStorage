package mySpring.ExpenseDataSrorage.Model;

import lombok.Data;

@Data
public class PaymentCreateDto {
    private int family_member;
    private int good;
    private int amount;
    private int unit_price;
    private String purchase_date;
}