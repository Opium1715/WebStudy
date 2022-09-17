package Bean;

public class Goods {
    private String goodsNo;

    private String goodsName;

    private String goodsPrice;

    private String goodsType;

    private String goodsNum;//库存量

    private String goodsSupply;//供应商名

    private String goodsImg;

    private String goodsDescription;

    private String judgeState;

    private Integer goodsSale;//销量

    private String goodsAddress;//供应商地址


    public Goods(String goodsNo, String goodsName, String goodsPrice, String goodsType, String goodsNum, String goodsSupply, String goodsImg, String goodsDescription, String judgeState, Integer goodsSale, String goodsAddress) {
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsType = goodsType;
        this.goodsNum = goodsNum;
        this.goodsSupply = goodsSupply;
        this.goodsImg = goodsImg;
        this.goodsDescription = goodsDescription;
        this.judgeState = judgeState;
        this.goodsSale = goodsSale;
        this.goodsAddress = goodsAddress;
    }

    public Goods(){}

    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getJudgeState() {
        return judgeState;
    }

    public void setJudgeState(String judgeState) {
        this.judgeState = judgeState;
    }

    public Integer getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(Integer goodsSale) {
        this.goodsSale = goodsSale;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsSupply() {
        return goodsSupply;
    }

    public void setGoodsSupply(String goodsSupply) {
        this.goodsSupply = goodsSupply;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsNo='" + goodsNo + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", goodsSupply='" + goodsSupply + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsDescription='" + goodsDescription + '\'' +
                ", judgeState='" + judgeState + '\'' +
                ", goodsSale=" + goodsSale +
                ", goodsAddress='" + goodsAddress + '\'' +
                '}';
    }
}
