package Bean;

public class Admin {

    private String AdminNo;

    private String AdminPassWord;

    public Admin(String adminNo, String adminPassWord) {
        AdminNo = adminNo;
        AdminPassWord = adminPassWord;
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }

    public String getAdminPassWord() {
        return AdminPassWord;
    }

    public void setAdminPassWord(String adminPassWord) {
        AdminPassWord = adminPassWord;
    }
}
