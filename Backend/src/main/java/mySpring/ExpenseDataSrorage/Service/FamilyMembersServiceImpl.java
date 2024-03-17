package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.FamilyMember;
import mySpring.ExpenseDataSrorage.Model.FamilyMemberCreateDto;
import mySpring.ExpenseDataSrorage.Repository.FamilyMemberRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FamilyMembersServiceImpl implements FamilyMembersService {
    private final FamilyMemberRepository repository;

    public FamilyMembersServiceImpl(FamilyMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FamilyMember> getFamilyMembers() throws SQLException {
        return repository.findAll();
    }

    @Override
    public FamilyMemberCreateDto saveFamilyMember(FamilyMemberCreateDto familyMemberCreateDto) throws SQLException {
        return repository.save(familyMemberCreateDto);
    }

    @Override
    public FamilyMember findFamilyMemberById(int id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public FamilyMember updateFamilyMember(FamilyMemberCreateDto familyMemberCreateDto, int id) throws SQLException {
        return repository.updateById(familyMemberCreateDto, id);
    }

    @Override
    public String deleteFamilyMember(int id) throws SQLException {
        return repository.deleteById(id);
    }
}