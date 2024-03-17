package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.GoodType;
import mySpring.ExpenseDataSrorage.Model.GoodTypeCreateDto;
import mySpring.ExpenseDataSrorage.Repository.GoodTypesRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GoodTypesServiceImpl implements GoodTypesService {
    private final GoodTypesRepository repository;

    public GoodTypesServiceImpl(GoodTypesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GoodType> getGoodTypes() throws SQLException {
        return repository.findAll();
    }

    @Override
    public GoodTypeCreateDto saveGoodType(GoodTypeCreateDto goodTypeCreateDto) throws SQLException {
        return repository.save(goodTypeCreateDto);
    }

    @Override
    public GoodType findGoodTypeById(int id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public GoodType updateGoodType(GoodTypeCreateDto goodTypeCreateDto, int id) throws SQLException {
        return repository.updateById(goodTypeCreateDto, id);
    }

    @Override
    public String deleteGoodType(int id) throws SQLException {
        return repository.deleteById(id);
    }
}