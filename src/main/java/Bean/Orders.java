package Bean;

public class Orders {
    private String orderNo;

    private String goodsNo;

    private String customerNo;

    private String orderState;

    private String orderDate;

    private String orderCost;

    private String goodsNum;

    public Orders(String orderNo, String goodsNo, String customerNo, String orderState, String orderDate, String orderCost, String goodsNum) {
        this.orderNo = orderNo;
        this.goodsNo = goodsNo;
        this.customerNo = customerNo;
        this.orderState = orderState;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.goodsNum = goodsNum;
    }

    public Orders(){}

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderNo='" + orderNo + '\'' +
                ", goodsNo='" + goodsNo + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderCost='" + orderCost + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                '}';
    }
}
