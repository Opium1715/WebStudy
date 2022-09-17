package Service;

import Bean.Goods;

import java.io.IOException;
import java.util.List;

public interface GoodsService {
//    List<Goods> getGoodsList(Integer PageNo,String Name,Integer lPrice,Integer hPrice,Integer Type);

    Integer getTotalPage(String Name, Integer lPrice, Integer hPrice, Integer Type, String Table, String busNo) throws IOException;

    String getSupplyName(String goodsSupply) throws IOException;

    List<Goods> getGoodsList(Integer PageNo, String Name, Integer lPrice, Integer hPrice, Integer Type, String Table, String Order, String busNo) throws IOException;

    void setJudgeState(String goodsNo,String State) throws IOException;

    Goods getGood(String goodsNo,String Table) throws IOException;

    void removeGoods(String goodsNo) throws IOException;

    void addGoods(Goods goods) throws IOException;
}
