package mySpring.ExpenseDataSrorage.Service;

import mySpring.ExpenseDataSrorage.Model.FamilyMember;
import mySpring.ExpenseDataSrorage.Model.FamilyMemberCreateDto;
import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface FamilyMembersService {
    List<FamilyMember> getFamilyMembers() throws SQLException;

    FamilyMemberCreateDto saveFamilyMember(FamilyMemberCreateDto familyMemberCreateDto) throws SQLException;

    FamilyMember findFamilyMemberById(int id) throws SQLException;

    FamilyMember updateFamilyMember(FamilyMemberCreateDto familyMemberCreateDto, int id) throws SQLException;

    String deleteFamilyMember(int id) throws SQLException;
}