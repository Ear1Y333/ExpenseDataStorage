package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.GoodType;
import mySpring.ExpenseDataSrorage.Model.GoodTypeCreateDto;

import java.sql.SQLException;
import java.util.List;

public interface GoodTypesService {
    List<GoodType> getGoodTypes() throws SQLException;

    GoodTypeCreateDto saveGoodType(GoodTypeCreateDto goodTypeCreateDto) throws SQLException;

    GoodType findGoodTypeById(int id) throws SQLException;

    GoodType updateGoodType(GoodTypeCreateDto goodTypeCreateDto, int id) throws SQLException;

    String deleteGoodType(int id) throws SQLException;
}