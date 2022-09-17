package Bean;

public class Business {
    private String businessNo;
    private String passWord;
    private String addRess;
    private String busName;
    private String postCode;
    private String telPhone;

    public Business(String businessNo, String passWord, String addRess, String busName, String postCode, String telPhone) {
        this.businessNo = businessNo;
        this.passWord = passWord;
        this.addRess = addRess;
        this.busName = busName;
        this.postCode = postCode;
        this.telPhone = telPhone;
    }

    public Business() {
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
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

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
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
        return "Business{" +
                "businessNo='" + businessNo + '\'' +
                ", passWord='" + passWord + '\'' +
                ", addRess='" + addRess + '\'' +
                ", busName='" + busName + '\'' +
                ", postCode='" + postCode + '\'' +
                ", telPhone='" + telPhone + '\'' +
                '}';
    }
}
