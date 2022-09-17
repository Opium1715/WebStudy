package Bean;

public class OrderDetail {
    private String orderNo;

    private String goodsName;

    private String orderState;

    private String orderCost;

    private String orderDate;

    private String busName;

    private String goodsNum;

    private String goodsImg;

    public OrderDetail(String orderNo, String goodsName, String orderState, String orderCost, String orderDate, String busName, String goodsNum, String goodsImg) {
        this.orderNo = orderNo;
        this.goodsName = goodsName;
        this.orderState = orderState;
        this.orderCost = orderCost;
        this.orderDate = orderDate;
        this.busName = busName;
        this.goodsNum = goodsNum;
        this.goodsImg = goodsImg;
    }

    public OrderDetail(){}

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderNo='" + orderNo + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderCost='" + orderCost + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", busName='" + busName + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                '}';
    }
}
