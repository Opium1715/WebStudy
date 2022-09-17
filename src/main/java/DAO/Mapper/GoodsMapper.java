package DAO.Mapper;

import Bean.Goods;

import java.util.List;

public interface GoodsMapper {
//    List<Goods> selectByPage(Integer PageNo,String Name,Integer lPrice,Integer hPrice,Integer Type);

    String selectSupplyName(String goodsSupply);

    Integer selectCount(String Name, Integer lPrice, Integer hPrice, Integer Type, String Table, String busNo);

    List<Goods> selectByPageNew(Integer PageNo, String Name, Integer lPrice, Integer hPrice, Integer Type, String Table, String Order, String busNo);

    void updateGoodsState(String goodsNo,String State);

    Goods selectGood(String goodsNo,String Table);

    Integer selectGoodsSale(String goodsNo);

    void deleteGoods(String goodsNo);

    void insertGoods(Goods goods);
}
