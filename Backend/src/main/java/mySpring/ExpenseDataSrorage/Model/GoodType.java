package mySpring.ExpenseDataSrorage.Model;

public class GoodType {
    private int goodTypeId;
    private String goodTypeName;

    public GoodType(int goodTypeId, String goodTypeName) {
        this.goodTypeId = goodTypeId;
        this.goodTypeName = goodTypeName;
    }

    public GoodType(int goodTypeId, GoodTypeCreateDto goodTypeCreateDto) {
        this.goodTypeId = goodTypeId;
        goodTypeName = goodTypeCreateDto.getGoodTypeName();
    }

    public int getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(int goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getGoodTypeName() {
        return goodTypeName;
    }

    public void setGoodTypeName(String goodTypeName) {
        this.goodTypeName = goodTypeName;
    }
}