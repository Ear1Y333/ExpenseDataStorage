package mySpring.ExpenseDataSrorage.Model;

public class GoodType {
    private int good_type_id;
    private String good_type_name;

    public GoodType(int good_type_id, String good_type_name) {
        this.good_type_id = good_type_id;
        this.good_type_name = good_type_name;
    }

    public GoodType(int good_type_id, GoodTypeCreateDto goodTypeCreateDto) {
        this.good_type_id = good_type_id;
        good_type_name = goodTypeCreateDto.getGood_type_name();
    }

    public int getGood_type_id() {
        return good_type_id;
    }

    public void setGood_type_id(int good_type_id) {
        this.good_type_id = good_type_id;
    }

    public String getGood_type_name() {
        return good_type_name;
    }

    public void setGood_type_name(String good_type_name) {
        this.good_type_name = good_type_name;
    }
}