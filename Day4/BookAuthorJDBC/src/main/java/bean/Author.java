package bean;

public class Author {
    private int authorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNo;

    public Author(){}

    public Author(String firstName, String middleName, String lastName, String phoneNo) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString(){
        return "AuthorID:" + authorId +
                "/nName: " + firstName +  middleName + lastName +
                "/nPhone:" + phoneNo;
    }

}
