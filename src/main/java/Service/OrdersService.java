package Service;

import Bean.OrderDetail;
import Bean.Orders;

import java.io.IOException;
import java.util.List;

public interface OrdersService {

    public List<Orders> getOrdersLists(int PageNo, String KeyWord, String busNo) throws IOException;

    public OrderDetail getOrder(String orderNo) throws IOException;

    public void updateOrder(String orderNo,String orderState) throws IOException;

    public Integer getTotalPages(String keyword, String busNo) throws IOException;
}
