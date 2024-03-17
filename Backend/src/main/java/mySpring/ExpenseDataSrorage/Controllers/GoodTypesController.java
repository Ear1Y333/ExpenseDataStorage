package mySpring.ExpenseDataSrorage.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.GoodType;
import mySpring.ExpenseDataSrorage.Model.GoodTypeCreateDto;
import mySpring.ExpenseDataSrorage.Service.GoodTypesServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/good_types")
@AllArgsConstructor
public class GoodTypesController {
    GoodTypesServiceImpl service;

    @GetMapping
    public List<GoodType> getGoodTypes() {
        try {
            return service.getGoodTypes();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("create")
    public GoodTypeCreateDto saveGood(@RequestBody GoodTypeCreateDto goodTypeCreateDto) {
        try {
            return service.saveGoodType(goodTypeCreateDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public GoodType findById(@PathVariable int id) {
        try {
            return service.findGoodTypeById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("{id}")
    public GoodType updatePayment(@RequestBody GoodTypeCreateDto goodTypeCreateDto, @PathVariable int id) {
        try {
            return service.updateGoodType(goodTypeCreateDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("{id}")
    public String deleteGoodType(@PathVariable int id) {
        try {
            return service.deleteGoodType(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}