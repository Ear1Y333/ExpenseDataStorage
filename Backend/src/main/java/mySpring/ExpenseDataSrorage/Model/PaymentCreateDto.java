package mySpring.ExpenseDataSrorage.Model;

import lombok.Data;

@Data
public class PaymentCreateDto {
    private int familyMember;
    private int good;
    private int amount;
    private int unitPrice;
    private String purchaseDate;
}