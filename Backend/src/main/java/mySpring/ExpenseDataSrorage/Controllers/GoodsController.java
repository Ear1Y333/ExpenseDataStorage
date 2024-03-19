package mySpring.ExpenseDataSrorage.Controllers;

import lombok.RequiredArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import mySpring.ExpenseDataSrorage.Service.GoodsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/goods")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsServiceImpl service;

    @GetMapping
    public List<Good> getGoods() {
        try {
            return service.getGoods();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("create")
    public GoodCreateDto saveGood(@RequestBody GoodCreateDto goodCreateDto) {
        try {
            return service.saveGood(goodCreateDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public Good findById(@PathVariable int id) {
        try {
            return service.findGoodById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("{id}")
    public Good updatePayment(@RequestBody GoodCreateDto goodCreateDto, @PathVariable int id) {
        try {
            return service.updateGood(goodCreateDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("{id}")
    public String deletePayment(@PathVariable int id) {
        try {
            return service.deleteGood(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}