package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.GoodType;
import mySpring.ExpenseDataSrorage.Model.GoodTypeCreateDto;

import java.util.List;

public interface GoodTypesService {
    List<GoodType> getGoodTypes();

    GoodTypeCreateDto saveGoodType(GoodTypeCreateDto goodTypeCreateDto);

    GoodType findGoodTypeById(int id);

    GoodType updateGoodType(GoodTypeCreateDto goodTypeCreateDto, int id);

    String deleteGoodType(int id);
}