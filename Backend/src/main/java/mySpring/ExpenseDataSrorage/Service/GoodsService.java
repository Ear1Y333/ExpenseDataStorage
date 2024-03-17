package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    List<Good> getGoods() throws SQLException;

    GoodCreateDto saveGood(GoodCreateDto goodCreateDto) throws SQLException;

    Good findGoodById(int id) throws SQLException;

    Good updateGood(GoodCreateDto goodCreateDto, int id) throws SQLException;

    String deleteGood(int id) throws SQLException;
}