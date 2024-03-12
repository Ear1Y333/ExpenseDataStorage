package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.GoodType;
import mySpring.ExpenseDataSrorage.Model.GoodTypeCreateDto;
import mySpring.ExpenseDataSrorage.Repository.GoodTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodTypesServiceImpl implements GoodTypesService {
    GoodTypesRepository repository = new GoodTypesRepository();
    @Override
    public List<GoodType> getGoodTypes() {
        return repository.findAll();
    }

    @Override
    public GoodTypeCreateDto saveGoodType(GoodTypeCreateDto goodTypeCreateDto) {
        return repository.save(goodTypeCreateDto);
    }

    @Override
    public GoodType findGoodTypeById(int id) {
        return repository.findById(id);
    }

    @Override
    public GoodType updateGoodType(GoodTypeCreateDto goodTypeCreateDto, int id) {
        return repository.updateById(goodTypeCreateDto, id);
    }

    @Override
    public String deleteGoodType(int id) {
        return repository.deleteById(id);
    }
}
