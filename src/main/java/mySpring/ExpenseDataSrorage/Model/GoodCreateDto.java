package mySpring.ExpenseDataSrorage.Model;

public class GoodCreateDto {
    private String good_name;
    private int type;

    public GoodCreateDto(String good_name, int type) {
        this.good_name = good_name;
        this.type = type;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getGood_name() {
        return good_name;
    }

    public int getType() {
        return type;
    }
}