package Controller;
import Bean.Business;
import Service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController {

    LoginService loginService= null;

    public LoginController() throws IOException {
    }

    //Login
    public String Login(String No, String PassWord, HttpServletRequest req) throws IOException {
        if(loginService.judgeLogin(No, PassWord)){
            HttpSession httpSession = req.getSession();
            Business business = loginService.getBus(No);
            if(business!=null){
                httpSession.setAttribute("Bus",business);
                return "redirect:Goods.do?BusNo="+business.getBusinessNo()+"&Table=unjudgedGoods";
            }
            else {
                if(httpSession.getAttribute("Bus")!=null)
                    httpSession.removeAttribute("Bus");
                return "redirect:Orders.do";
            }
        }
        else {
            String msg = "用户名或密码错误，请重试！";
            req.setAttribute("Msg",msg);
            return "Login";
        }
    }

    //Display
    public String DisplayLogin(){
        return "Login";
    }
}
