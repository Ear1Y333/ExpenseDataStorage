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
}
