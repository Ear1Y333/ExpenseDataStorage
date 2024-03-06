package mySpring.springPractice.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payment {
    private int id;
    private int family_member;
    private int good;
    private int amount;
    private int unit_price;
    private String purchase_date;

}
