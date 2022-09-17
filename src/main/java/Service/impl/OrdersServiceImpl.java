package Service.impl;

import Bean.OrderDetail;
import Bean.Orders;
import DAO.Mapper.OrdersMapper;
import Service.OrdersService;
import Util.PageUtil.Pages;
import Util.SQL.SqlConnector;

import java.io.IOException;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    public OrdersServiceImpl() throws IOException {
    }


    @Override
    public List<Orders> getOrdersLists(int PageNo, String KeyWord, String busNo) throws IOException {
        OrdersMapper ordersMapper=SqlConnector.getSqlSession().getMapper(OrdersMapper.class);
        return ordersMapper.selectByPages(PageNo, KeyWord,busNo);
    }

    @Override
    public OrderDetail getOrder(String orderNo) throws IOException {
        OrdersMapper ordersMapper=SqlConnector.getSqlSession().getMapper(OrdersMapper.class);
        return ordersMapper.selectById(orderNo);
    }

    @Override
    public void updateOrder(String orderNo,String orderState) throws IOException {
        OrdersMapper ordersMapper=SqlConnector.getSqlSession().getMapper(OrdersMapper.class);
        ordersMapper.updateOrder(orderNo,orderState);
    }

    @Override
    public Integer getTotalPages(String keyword, String busNo) throws IOException {
        OrdersMapper ordersMapper=SqlConnector.getSqlSession().getMapper(OrdersMapper.class);
        return Pages.TotalPage(ordersMapper.selectCount(keyword,busNo));
    }
}
