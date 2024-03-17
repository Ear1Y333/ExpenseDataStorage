package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.FamilyMember;
import mySpring.ExpenseDataSrorage.Model.FamilyMemberCreateDto;
import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FamilyMembersService {
    List<FamilyMember> getFamilyMembers();

    FamilyMemberCreateDto saveFamilyMember(FamilyMemberCreateDto familyMemberCreateDto);

    FamilyMember findFamilyMemberById(int id);

    FamilyMember updateFamilyMember(FamilyMemberCreateDto familyMemberCreateDto, int id);

    String deleteFamilyMember(int id);
}