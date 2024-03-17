package mySpring.ExpenseDataSrorage.Model;

public class Good {
    private int good_id;
    private String good_name;
    private int type;

    public Good(int good_id, String good_name, int type) {
        this.good_id = good_id;
        this.good_name = good_name;
        this.type = type;
    }

    public Good(int good_id, GoodCreateDto goodCreateDto) {
        this.good_id = good_id;
        good_name = goodCreateDto.getGood_name();
        type = goodCreateDto.getType();
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}