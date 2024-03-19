package mySpring.ExpenseDataSrorage.Model;

import lombok.Data;

@Data
public class FamilyMemberCreateDto {
    private String status;
    private String memberName;
    private String birthday;
}