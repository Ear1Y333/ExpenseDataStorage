package mySpring.ExpenseDataSrorage.Model;

public class FamilyMember {
    private int id;
    private String status;
    private String memberName;
    private String birthday;

    public FamilyMember(int id, String status, String memberName, String birthday) {
        this.id = id;
        this.status = status;
        this.memberName = memberName;
        this.birthday = birthday;
    }

    public FamilyMember(int id, FamilyMemberCreateDto familyMemberCreateDto) {
        this.id = id;
        status = familyMemberCreateDto.getStatus();
        memberName = familyMemberCreateDto.getMemberName();
        birthday = familyMemberCreateDto.getBirthday();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getmemberName() {
        return memberName;
    }

    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}