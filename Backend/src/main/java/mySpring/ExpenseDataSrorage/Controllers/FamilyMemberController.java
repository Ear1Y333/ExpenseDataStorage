package mySpring.ExpenseDataSrorage.Controllers;

import lombok.RequiredArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.FamilyMember;
import mySpring.ExpenseDataSrorage.Model.FamilyMemberCreateDto;
import mySpring.ExpenseDataSrorage.Service.FamilyMembersService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/family_members")
@RequiredArgsConstructor
public class FamilyMemberController {
    private final FamilyMembersService service;

    @GetMapping
    public List<FamilyMember> getFamilyMembers() {
        try {
            return service.getFamilyMembers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("create")
    public FamilyMemberCreateDto saveFamilyMember(@RequestBody FamilyMemberCreateDto familyMemberCreateDto) {
        try {
            return service.saveFamilyMember(familyMemberCreateDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public FamilyMember findById(@PathVariable int id) {
        try {
            return service.findFamilyMemberById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("{id}")
    public FamilyMember updateFamilyMember(@RequestBody FamilyMemberCreateDto familyMemberCreateDto, @PathVariable int id) {
        try {
            return service.updateFamilyMember(familyMemberCreateDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("{id}")
    public String deleteFamilyMember(@PathVariable int id) {
        try {
            return service.deleteFamilyMember(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}