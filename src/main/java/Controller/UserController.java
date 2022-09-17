package Controller;

import Bean.Business;
import Bean.User;
import Service.UserService;
import Util.PageUtil.Pages;
import com.mysql.cj.PreparedQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController {

    UserService userService = null;

    public UserController() {
    }

    //Add
    public String AddUser(String No, String passWord, String addRess, String Name, String postCode , String telPhone,HttpSession session) throws IOException {
        String Type = (String) session.getAttribute("Type");
        if(Type.equals("User")){
            User user=new User(No,passWord,addRess,Name,postCode,telPhone);
            userService.addUser(user,Type);
        }
        else {
            Business business = new Business(No,passWord,addRess,Name,postCode,telPhone);
            userService.addUser(business,Type);
        }
        return "redirect:User.do";
    }
    //Delete
    public String DeleteUser(String No,HttpSession session) throws IOException {
        String Type = (String) session.getAttribute("Type");
        if(Type.equals("User")){
            userService.delUser(No,Type);
        }
        else {
            userService.delUser(No,Type);
        }
        return "redirect:User.do";
    }
    //Update
    public String UpdateUser(String No, String passWord, String addRess, String Name, String postCode, String telPhone,HttpSession session,HttpServletRequest req) throws IOException {
        String Type = (String) session.getAttribute("Type");
        if(Type==null)
            Type = (String) req.getParameter("Type");
        if(Type.equals("User")){
            User user=new User(No,passWord,addRess,Name,postCode,telPhone);
            userService.updateUser(user,Type);
        }
        else {
            Business business = new Business(No,passWord,addRess,Name,postCode,telPhone);
            userService.updateUser(business,Type);
            session.setAttribute("Bus",business);
        }
        if(session.getAttribute("Bus")!=null){
            Business business = (Business) session.getAttribute("Bus");
            return "redirect:User.do?operate=EditUser&No="+business.getBusinessNo();
        }
        return "redirect:User.do";
    }
    //Edit
    public String EditUser(String No, HttpServletRequest req,HttpSession session) throws IOException {
        //更新和添加先访问editUser()
        if(No != null){
            if(session.getAttribute("Bus")!=null){
                return "BusModify";
            }
            else {
                String Type = (String) session.getAttribute("Type");
                if(Type.equals("User")){
                    User user = (User) userService.getUserById(No,Type);
                    req.setAttribute("User",user);
                }
                else {
                    Business business = (Business) userService.getUserById(No,Type);
                    req.setAttribute("User",business);
                }
                return "editUpdate";
            }
        }
        else {
            return "editAdd";
        }
    }
    //Display
    public String DisplayUser(Integer PageNo,String keyword,String option,HttpServletRequest req,String Type) throws IOException {
        HttpSession httpSession=req.getSession();
        System.out.println(httpSession.getId());


        if(option!=null&&option.equals("search")){
            PageNo=1;
            httpSession.setAttribute("PageNo",PageNo);
            if(keyword!=null){
                httpSession.setAttribute("KeyWord",keyword);//将关键字存入会话域中，为跳转下一页做判断
            }
        }
        else {
            if(httpSession.getAttribute("KeyWord")!=null){
                keyword= (String) httpSession.getAttribute("KeyWord");
            }
        }
        //判断类型是否为空
        if(Type!=null){
            httpSession.setAttribute("Type",Type);
        }
        else{
            Type= (String) httpSession.getAttribute("Type");
        }


        if (PageNo==null){
            if(httpSession.getAttribute("PageNo")!=null){
                PageNo=(Integer) httpSession.getAttribute("PageNo");
            }
            else {
                PageNo = 1;
            }
        }

        //更新之后的请求中并不包含页码数


        httpSession.setAttribute("PageNo",PageNo);
        httpSession.setAttribute("UserList",userService.getUserList(Pages.PageCompute(PageNo),keyword,Type));

//        int totalPages=(mapper.selectCount(keyword))/9+1;
        httpSession.setAttribute("totalPages",userService.getTotalPages(keyword,Type));

        return "UserDisplay";
    }
}