package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import mySpring.ExpenseDataSrorage.Repository.GoodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService{
    private final GoodsRepository repository;

    public GoodsServiceImpl(GoodsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Good> getGoods() {
        return repository.findAll();
    }

    @Override
    public GoodCreateDto saveGood(GoodCreateDto good) {
        return repository.save(good);
    }

    @Override
    public Good findGoodById(int id) {
        return repository.findById(id);
    }

    @Override
    public Good updateGood(GoodCreateDto goodCreateDto, int id) {
        return repository.updateById(goodCreateDto, id);
    }

    @Override
    public String deleteGood(int id) {
        return repository.deleteById(id);
    }
}
