package mySpring.ExpenseDataSrorage.Model;

public class FamilyMember {
    private int id;
    private String status;
    private String member_name;
    private String birthday;

    public FamilyMember(int id, String status, String member_name, String birthday) {
        this.id = id;
        this.status = status;
        this.member_name = member_name;
        this.birthday = birthday;
    }

    public FamilyMember(int id, FamilyMemberCreateDto familyMemberCreateDto) {
        this.id = id;
        status = familyMemberCreateDto.getStatus();
        member_name = familyMemberCreateDto.getMember_name();
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

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}