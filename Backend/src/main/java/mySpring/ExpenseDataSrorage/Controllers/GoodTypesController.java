package mySpring.ExpenseDataSrorage.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.GoodType;
import mySpring.ExpenseDataSrorage.Model.GoodTypeCreateDto;
import mySpring.ExpenseDataSrorage.Service.GoodTypesServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/good_types")
@AllArgsConstructor
public class GoodTypesController {
    GoodTypesServiceImpl service;

    @GetMapping
    public List<GoodType> getGoodTypes() {
        return service.getGoodTypes();
    }

    @PostMapping("create")
    public GoodTypeCreateDto saveGood(@RequestBody GoodTypeCreateDto goodTypeCreateDto) {
        return service.saveGoodType(goodTypeCreateDto);
    }

    @GetMapping("{id}")
    public GoodType findById(@PathVariable int id) {
        return service.findGoodTypeById(id);
    }

    @PutMapping("{id}")
    public GoodType updatePayment(@RequestBody GoodTypeCreateDto goodTypeCreateDto, @PathVariable int id) {
        return service.updateGoodType(goodTypeCreateDto, id);
    }

    @DeleteMapping("{id}")
    public String deleteGoodType(@PathVariable int id) {
        return service.deleteGoodType(id);
    }
}
