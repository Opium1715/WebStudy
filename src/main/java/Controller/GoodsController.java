package Controller;

import Bean.Business;
import Bean.Goods;
import Service.GoodsService;
import Util.PageUtil.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoodsController {

    GoodsService goodsService=null;

    static boolean order_Now;
    //Retrieve
    public String DisplayGoods(Integer PageNo,String Name, Integer lPrice, Integer hPrice, Integer type, String option, HttpServletRequest req,
                               String Table, String Order,String BusNo) throws IOException {
        HttpSession httpSession= req.getSession();
        System.out.println("HttpSession="+httpSession);

        //处理当前排序顺序
        if(Order!=null&&!Order.isEmpty()){
            if(!order_Now){
                Order="asc";
                httpSession.setAttribute("Order",Order);
                order_Now=true;
            }
            else {
                order_Now=false;
                Order="desc";
                httpSession.setAttribute("Order",Order);
            }
        }
        else {
            Order = null;
        }
        //存储当前查询表
        if(Table!=null&&!Table.isEmpty()){
            httpSession.setAttribute("Table",Table);
        }
        else {
            Table= (String) httpSession.getAttribute("Table");
        }


        if(option!=null&&option.equals("search")){
            PageNo=1;
            httpSession.setAttribute("PageNo",PageNo);
            if(Name!=null){
                httpSession.setAttribute("Name",Name);//将关键字存入会话域中，为跳转下一页做判断
            }
            if(lPrice!=null){
                httpSession.setAttribute("lPrice",lPrice);
            }
            if(hPrice!=null){
                httpSession.setAttribute("hPrice",hPrice);
            }
//            if(type!=null){
                httpSession.setAttribute("type",type);
//            }
        }
        else {
//            if(httpSession.getAttribute("Name")!=null){
//                Name= (String) httpSession.getAttribute("Name");
//            }
            if(lPrice==null){
                lPrice= (Integer) httpSession.getAttribute("lPrice");
            }
            if(hPrice==null){
                hPrice= (Integer) httpSession.getAttribute("hPrice");
            }
            if(httpSession.getAttribute("type")!=null){
                type = (Integer) httpSession.getAttribute("type");
            }
            if(httpSession.getAttribute("Order")!=null){
                Order = (String) httpSession.getAttribute("Order");
            }
        }

        if(PageNo==null){ //如果页数为null
            if(httpSession.getAttribute("PageNo")!=null){
                PageNo=(Integer) httpSession.getAttribute("PageNo");
            }
            else{
                PageNo=1;
            }
        }

        if(BusNo==null){
            if(httpSession.getAttribute("Bus")!=null){
                Business business = (Business) httpSession.getAttribute("Bus");
                BusNo= business.getBusinessNo();
            }
        }

        httpSession.setAttribute("PageNo",PageNo);
        httpSession.setAttribute("GoodsList",goodsService.getGoodsList(Pages.PageCompute(PageNo),Name,lPrice,hPrice,type,Table,Order,BusNo));
        httpSession.setAttribute("totalPages",goodsService.getTotalPage(Name, lPrice, hPrice, type, Table,BusNo));

        if(Table.equals("Goods")){
            return "GoodsDisplay";
        } else  {
            if(BusNo!=null){
                return "BusGoods";
            }
            else {
                return "unGoodsDisplay";
            }
        }
    }

    //Update
    public String UpdateGoods(String goodsNo,String State,String Table) throws IOException {
        goodsService.setJudgeState(goodsNo,State);
        return "redirect:Goods.do?Table="+Table;
    }

    //Edit
    public String EditGoods(String goodsNo,String Table,HttpServletRequest req) throws IOException {
        if(goodsNo!=null){
            Goods goods = goodsService.getGood(goodsNo,Table);
            req.setAttribute("goods",goods);
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("goodsImg",goods.getGoodsImg());
            return "GoodsDetail";
        }
        else {
            return "GoodsAdd";
        }
    }
    //Delete
    public String DeleteGoods(String goodsNo,HttpSession session) throws IOException {
        goodsService.removeGoods(goodsNo);
        if(session.getAttribute("Bus")!=null){
            Business business = (Business)session.getAttribute("Bus");
            return "redirect:Goods.do?BusNo="+business.getBusinessNo()+"&Table=unjudgedGoods";
        }
        else
            return "redirect:Goods.do?Table=Goods";
    }
    //Create
    public String AddGoods(String Name,String Price,String type, String Num,String href,String description,HttpSession session ) throws IOException {
        Business business = (Business) session.getAttribute("Bus");
        Goods goods = new Goods(null,Name,Price, type,Num, business.getBusinessNo(), href,description,null,null,null);
        goodsService.addGoods(goods);
        return "redirect:Goods.do?Table=unjudgedGoods";
    }
}
