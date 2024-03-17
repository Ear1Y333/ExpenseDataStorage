package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import mySpring.ExpenseDataSrorage.Repository.GoodsRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository repository;

    public GoodsServiceImpl(GoodsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Good> getGoods() throws SQLException {
        return repository.findAll();
    }

    @Override
    public GoodCreateDto saveGood(GoodCreateDto good) throws SQLException {
        return repository.save(good);
    }

    @Override
    public Good findGoodById(int id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public Good updateGood(GoodCreateDto goodCreateDto, int id) throws SQLException {
        return repository.updateById(goodCreateDto, id);
    }

    @Override
    public String deleteGood(int id) throws SQLException {
        return repository.deleteById(id);
    }
}