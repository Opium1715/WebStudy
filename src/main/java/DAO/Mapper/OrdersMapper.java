package DAO.Mapper;

import Bean.OrderDetail;
import Bean.Orders;

import java.util.List;

public interface OrdersMapper {

    List<Orders> selectByPages(int PageNo, String keyWord, String busNo);

    OrderDetail selectById(String orderNo);

    void updateOrder(String orderNo,String orderState);

    int selectCount(String keyWord, String busNo);


}
