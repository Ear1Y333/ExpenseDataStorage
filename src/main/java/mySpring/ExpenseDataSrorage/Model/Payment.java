package mySpring.ExpenseDataSrorage.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Payment {
    @Id
    private long id;
    private int family_member;
    private int good;
    private int amount;
    private int unit_price;
    private String purchase_date;

    public Payment(int id, int family_member, int good, int amount, int unit_price, String purchase_date) {
        this.id = id;
        this.family_member = family_member;
        this.good = good;
        this.amount = amount;
        this.unit_price = unit_price;
        this.purchase_date = purchase_date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", family_member=" + family_member +
                ", good=" + good +
                ", amount=" + amount +
                ", unit_price=" + unit_price +
                ", purchase_date='" + purchase_date + '\'' +
                '}';
    }
}
