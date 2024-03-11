package mySpring.ExpenseDataSrorage.Controllers;

import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import mySpring.ExpenseDataSrorage.Service.GoodsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@AllArgsConstructor
//@Tag
public class GoodsController {
    GoodsServiceImpl goodsService;

    @GetMapping
    public List<Good> getGoods(){
        return goodsService.getGoods();
    }

    @PostMapping("create")
    public GoodCreateDto saveGood(@RequestBody GoodCreateDto goodCreateDto) {
        return goodsService.saveGood(goodCreateDto);
    }
    @GetMapping("{id}")
    public Good findById(@PathVariable int id){
        return goodsService.findGoodById(id);
    }
    @PutMapping("{id}")
    public Good updatePayment(@RequestBody GoodCreateDto goodCreateDto, @PathVariable int id) {
        return goodsService.updateGood(goodCreateDto, id);
    }
    @DeleteMapping("{id}")
    public String deletePayment(@PathVariable int id) {
        return goodsService.deleteGood(id);
    }


}
