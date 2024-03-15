package mySpring.ExpenseDataSrorage.Model;
public class Payment {
    private int id;
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
    public Payment(int id, PaymentCreateDto paymentCreate) {
        this.id = id;
        family_member = paymentCreate.getFamily_member();
        good = paymentCreate.getGood();
        amount = paymentCreate.getAmount();
        unit_price = paymentCreate.getUnit_price();
        purchase_date = paymentCreate.getPurchase_date();
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFamily_member(int family_member) {
        this.family_member = family_member;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public int getId() {
        return id;
    }

    public int getFamily_member() {
        return family_member;
    }

    public int getGood() {
        return good;
    }

    public int getAmount() {
        return amount;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public String getPurchase_date() {
        return purchase_date;
    }
}