package mySpring.ExpenseDataSrorage.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import mySpring.ExpenseDataSrorage.Service.GoodsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Timer;

@RestController
@RequestMapping("/api/goods")
@AllArgsConstructor
public class GoodsController {
    GoodsServiceImpl service;

    @GetMapping
    public List<Good> getGoods() {
        return service.getGoods();
    }

    @PostMapping("create")
    public GoodCreateDto saveGood(@RequestBody GoodCreateDto goodCreateDto) {
        return service.saveGood(goodCreateDto);
    }

    @GetMapping("{id}")
    public Good findById(@PathVariable int id) {
        return service.findGoodById(id);
    }

    @PutMapping("{id}")
    public Good updatePayment(@RequestBody GoodCreateDto goodCreateDto, @PathVariable int id) {
        return service.updateGood(goodCreateDto, id);
    }

    @DeleteMapping("{id}")
    public String deletePayment(@PathVariable int id) {
        return service.deleteGood(id);
    }


}
