package Util.Test;

import Bean.Business;
import Bean.Goods;
import Bean.User;
import DAO.Mapper.OrdersMapper;
import Service.GoodsService;
import Service.LoginService;
import Service.OrdersService;
import Service.UserService;
import Service.impl.GoodsServiceImpl;
import Service.impl.LoginServiceImpl;
import Service.impl.OrdersServiceImpl;
import Service.impl.UserServiceImpl;
import Util.SQL.SqlConnector;
import Util.SQL.TransactionManager;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class Sqltest {
    @Test
    public void test() throws IOException {

        TransactionManager.beginTran();

        UserService userService = new UserServiceImpl();

        GoodsService goodsService = new GoodsServiceImpl();

        OrdersService ordersService = new OrdersServiceImpl();

        System.out.println("---------------------------------------------------------------------------");

//        System.out.println(goodsService.getGood("G000000007", "Goods"));
//
//        System.out.println("----------------------------------------------------------------------------");
//
//        System.out.println(goodsService.getGoodsList(Pages.PageCompute(1),"",null,null,1,"unjudgedGoods","asc" ));
//
//        System.out.println("-----------------------------------------------------------------------------");
//
//        System.out.println(goodsService.getTotalPage(null,null,null,null,"Goods"));
//
//        System.out.println("------------------------------------------------------------------------------");


        System.out.println(userService.getUserById("123","Bus"));//null

        System.out.println(goodsService.getGoodsList(0,null,null,null,null,"unjudgedGoods",null,"B000000002"));

        System.out.println(goodsService.getTotalPage(null,null,null,null,"unjudgedGoods","B000000002"));

        System.out.println(ordersService.getOrdersLists(0,null,"B000000002"));

        System.out.println(ordersService.getTotalPages(null,"B000000002"));

        System.out.println("------------------------------------------------------------------------------");
//
//        System.out.println(goodsService.getTotalPage(null,null,null,null,"unjudgedGoods"));
//        ordersMapper.updateOrder("R000000026","已收货",2999.99);
        TransactionManager.commitTran();

    }
}
