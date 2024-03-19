package mySpring.ExpenseDataSrorage.Model;

public class Payment {
    private int id;
    private int familyMember;
    private int good;
    private int amount;
    private int unitPrice;
    private String purchaseDate;

    public Payment(int id, int familyMember, int good, int amount, int unitPrice, String purchaseDate) {
        this.id = id;
        this.familyMember = familyMember;
        this.good = good;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.purchaseDate = purchaseDate;
    }

    public Payment(int id, PaymentCreateDto paymentCreate) {
        this.id = id;
        familyMember = paymentCreate.getFamilyMember();
        good = paymentCreate.getGood();
        amount = paymentCreate.getAmount();
        unitPrice = paymentCreate.getUnitPrice();
        purchaseDate = paymentCreate.getPurchaseDate();
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFamilyMember(int familyMember) {
        this.familyMember = familyMember;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getId() {
        return id;
    }

    public int getFamilyMember() {
        return familyMember;
    }

    public int getGood() {
        return good;
    }

    public int getAmount() {
        return amount;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }
}