package mySpring.ExpenseDataSrorage.Repository;

import mySpring.ExpenseDataSrorage.Connection.SQLConnection;
import mySpring.ExpenseDataSrorage.Model.FamilyMember;
import mySpring.ExpenseDataSrorage.Model.FamilyMemberCreateDto;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FamilyMemberRepository {
    private final String QUERY_TO_FIND_ALL_GOODS = "SELECT * FROM FamilyMembers";
    private final String QUERY_TO_INSERT_VALUES = "INSERT INTO FamilyMembers (status, member_name, birthday) VALUES('%s', '%s', '%s')";
    private final String QUERY_TO_FIND_BY_ID = "SELECT * FROM FamilyMembers WHERE id = %d";
    private final String QUERY_TO_UPDATE_BY_ID = "UPDATE FamilyMembers SET status = '%s', member_name = '%s', birthday = '%s' WHERE id = %d";
    private final String QUERY_TO_DELETE_BY_ID = "DELETE FROM FamilyMembers WHERE id = %d";
    private final String MESSAGE_FOR_UNSUCCESSFUL_DELETION = "No family member with id = %d";
    private final String MESSAGE_FOR_SUCCESSFUL_DELETION = "Family member with id = %d was successfully deleted";
    private final Statement statement;

    public FamilyMemberRepository(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FamilyMember> findAll(){
        try {
            ArrayList<FamilyMember> familyMembers = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_ALL_GOODS);
            while (resultSet.next()){
                FamilyMember familyMember = new FamilyMember
                        (resultSet.getInt("id"), resultSet.getString("status"),
                                resultSet.getString("member_name"), resultSet.getString("birthday"));
                familyMembers.add(familyMember);
            }
            return familyMembers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public FamilyMemberCreateDto save(FamilyMemberCreateDto familyMemberCreateDto){
        try {
            statement.execute(QUERY_TO_INSERT_VALUES.formatted(familyMemberCreateDto.getStatus(), familyMemberCreateDto.getMember_name(),
                    familyMemberCreateDto.getBirthday()));
            return familyMemberCreateDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public FamilyMember findById(int id){
        try {
            ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_BY_ID.formatted(id));
            if(resultSet.next()){
                return new FamilyMember(resultSet.getInt("id"), resultSet.getString("status"),
                        resultSet.getString("member_name"), resultSet.getString("birthday"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public FamilyMember updateById(FamilyMemberCreateDto familyMemberCreateDto, int id){
        try {
            if (statement.executeUpdate(QUERY_TO_UPDATE_BY_ID.
                    formatted(familyMemberCreateDto.getStatus(), familyMemberCreateDto.getMember_name(),
                            familyMemberCreateDto.getBirthday(), id))==0)
                return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new FamilyMember(id, familyMemberCreateDto);
    }
    public String deleteById(int id){
        try {
            if (statement.executeUpdate(QUERY_TO_DELETE_BY_ID.formatted(id)) == 0) return MESSAGE_FOR_UNSUCCESSFUL_DELETION.formatted(id);

        } catch (SQLException e) {
            e.getErrorCode();
        }
        return MESSAGE_FOR_SUCCESSFUL_DELETION.formatted(id);
    }
}