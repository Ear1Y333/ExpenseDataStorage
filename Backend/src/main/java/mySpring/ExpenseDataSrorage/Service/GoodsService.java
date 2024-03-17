package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;

import java.util.List;

public interface GoodsService {
    List<Good> getGoods();

    GoodCreateDto saveGood(GoodCreateDto goodCreateDto);

    Good findGoodById(int id);

    Good updateGood(GoodCreateDto goodCreateDto, int id);

    String deleteGood(int id);
}