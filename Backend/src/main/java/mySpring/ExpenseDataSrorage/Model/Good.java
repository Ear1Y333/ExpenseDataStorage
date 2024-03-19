package mySpring.ExpenseDataSrorage.Model;

public class Good {
    private int goodId;
    private String goodName;
    private int type;

    public Good(int goodId, String goodName, int type) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.type = type;
    }

    public Good(int goodId, GoodCreateDto goodCreateDto) {
        this.goodId = goodId;
        goodName = goodCreateDto.getGoodName();
        type = goodCreateDto.getType();
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}