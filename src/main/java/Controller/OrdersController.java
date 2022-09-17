package Controller;

import Bean.Business;
import Bean.OrderDetail;
import Service.OrdersService;
import Util.PageUtil.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrdersController {

    OrdersService ordersService=null;

    //Retrieve
    public String DisplayOrders(Integer PageNo, String keyword, String option, HttpServletRequest req,String BusNo) throws IOException {
        HttpSession httpSession= req.getSession();
        System.out.println(httpSession);



        if(option!=null&&option.equals("search")){
            PageNo=1;
            httpSession.setAttribute("PageNo",PageNo);
            if(!keyword.isEmpty()){
                httpSession.setAttribute("KeyWord",keyword);//将关键字存入会话域中，为跳转下一页做判断
            }
        }
        else {
            if(httpSession.getAttribute("KeyWord")!=null){
                keyword= (String) httpSession.getAttribute("KeyWord");
            }
        }
        if(PageNo==null){
            if(httpSession.getAttribute("PageNo")!=null){
                PageNo=(Integer) httpSession.getAttribute("PageNo");
            }
            else {
                PageNo = 1;
            }
        }

        if(BusNo==null){
            if(httpSession.getAttribute("Bus")!=null){
                Business business = (Business) httpSession.getAttribute("Bus");
                BusNo= business.getBusinessNo();
            }
        }

        //更新之后的请求中并不包含页码数



        httpSession.setAttribute("PageNo",PageNo);
        httpSession.setAttribute("OrdersList",ordersService.getOrdersLists(Pages.PageCompute(PageNo),keyword,BusNo));

//        int totalPages=(mapper.selectCount(keyword))/9+1;
        httpSession.setAttribute("totalPages",ordersService.getTotalPages(keyword,BusNo));


        if(BusNo!=null){
            return "BusOrders";
        }
        else
            return "OrderDisplay";//返回html的名称信息
    }

    //Update
    public String UpdateOrder(String orderNo,String orderState) throws IOException {
        ordersService.updateOrder(orderNo, orderState);
        return "redirect:Orders.do";
    }

    //Edit
    public String EditOrder(String orderNo,HttpServletRequest req,HttpSession session) throws IOException {
        OrderDetail orderDetail=ordersService.getOrder(orderNo);
        req.setAttribute("Order",orderDetail);
        session.setAttribute("goodsImg",orderDetail.getGoodsImg());
        return "OrderDetail";
    }
}
