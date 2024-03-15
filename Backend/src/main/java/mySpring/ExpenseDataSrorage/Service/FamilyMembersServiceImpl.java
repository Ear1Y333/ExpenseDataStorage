package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.FamilyMember;
import mySpring.ExpenseDataSrorage.Model.FamilyMemberCreateDto;
import mySpring.ExpenseDataSrorage.Repository.FamilyMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMembersServiceImpl implements FamilyMembersService {
    private final FamilyMemberRepository repository;
    public FamilyMembersServiceImpl(FamilyMemberRepository repository){
        this.repository = repository;
    }
    @Override
    public List<FamilyMember> getFamilyMembers() {
        return repository.findAll();
    }

    @Override
    public FamilyMemberCreateDto saveFamilyMember(FamilyMemberCreateDto familyMemberCreateDto) {
        return repository.save(familyMemberCreateDto);
    }

    @Override
    public FamilyMember findFamilyMemberById(int id) {
        return repository.findById(id);
    }

    @Override
    public FamilyMember updateFamilyMember(FamilyMemberCreateDto familyMemberCreateDto, int id) {
        return repository.updateById(familyMemberCreateDto, id);
    }

    @Override
    public String deleteFamilyMember(int id) {
        return repository.deleteById(id);
    }
}