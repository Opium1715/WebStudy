package Bean;

public class User {

    private String customerNo;

    private String passWord;

    private String addRess;

    private String userName;

    private String postCode;

    private String telPhone;

    public User(String customerNo, String passWord, String addRess, String userName, String postCode, String telPhone) {
        this.customerNo = customerNo;
        this.passWord = passWord;
        this.addRess = addRess;
        this.userName = userName;
        this.postCode = postCode;
        this.telPhone = telPhone;
    }

    public User() {
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddRess() {
        return addRess;
    }

    public void setAddRess(String addRess) {
        this.addRess = addRess;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "customerNo='" + customerNo + '\'' +
                ", passWord='" + passWord + '\'' +
                ", addRess='" + addRess + '\'' +
                ", userName='" + userName + '\'' +
                ", postCode='" + postCode + '\'' +
                ", telPhone='" + telPhone + '\'' +
                '}';
    }
}
