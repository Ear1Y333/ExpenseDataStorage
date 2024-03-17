package mySpring.ExpenseDataSrorage.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mySpring.ExpenseDataSrorage.Model.FamilyMember;
import mySpring.ExpenseDataSrorage.Model.FamilyMemberCreateDto;
import mySpring.ExpenseDataSrorage.Service.FamilyMembersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/family_members")
@AllArgsConstructor
public class FamilyMemberController {
    FamilyMembersService service;

    @GetMapping
    public List<FamilyMember> getFamilyMembers() {
        return service.getFamilyMembers();
    }

    @PostMapping("create")
    public FamilyMemberCreateDto saveFamilyMember(@RequestBody FamilyMemberCreateDto familyMemberCreateDto) {
        return service.saveFamilyMember(familyMemberCreateDto);
    }

    @GetMapping("{id}")
    public FamilyMember findById(@PathVariable int id) {
        return service.findFamilyMemberById(id);
    }

    @PutMapping("{id}")
    public FamilyMember updateFamilyMember(@RequestBody FamilyMemberCreateDto familyMemberCreateDto, @PathVariable int id) {
        return service.updateFamilyMember(familyMemberCreateDto, id);
    }

    @DeleteMapping("{id}")
    public String deleteFamilyMember(@PathVariable int id) {
        return service.deleteFamilyMember(id);
    }
}