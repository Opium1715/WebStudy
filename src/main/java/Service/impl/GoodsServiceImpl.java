package Service.impl;

import Bean.Goods;
import DAO.Mapper.GoodsMapper;
import Service.GoodsService;
import Util.PageUtil.Pages;
import Util.SQL.SqlConnector;

import java.io.IOException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    public GoodsServiceImpl() {
    }

    @Override
    public Integer getTotalPage(String Name, Integer lPrice, Integer hPrice, Integer Type, String Table, String busNo) throws IOException {
        GoodsMapper goodsMapper = SqlConnector.getSqlSession().getMapper(GoodsMapper.class);
        return Pages.TotalPage(goodsMapper.selectCount(Name, lPrice, hPrice, Type,Table,busNo));
    }

    @Override
    public String getSupplyName(String goodsSupply) throws IOException {
        GoodsMapper goodsMapper = SqlConnector.getSqlSession().getMapper(GoodsMapper.class);
        return goodsMapper.selectSupplyName(goodsSupply);
    }

    @Override
    public List<Goods> getGoodsList(Integer PageNo, String Name, Integer lPrice, Integer hPrice, Integer Type, String Table, String Order, String busNo) throws IOException {
        GoodsMapper goodsMapper = SqlConnector.getSqlSession().getMapper(GoodsMapper.class);
        return goodsMapper.selectByPageNew(PageNo, Name, lPrice, hPrice, Type,Table,Order,busNo);
    }

    @Override
    public void setJudgeState(String goodsNo, String State) throws IOException {
        GoodsMapper goodsMapper = SqlConnector.getSqlSession().getMapper(GoodsMapper.class);
        goodsMapper.updateGoodsState(goodsNo,State);
    }

    @Override
    public Goods getGood(String goodsNo, String Table) throws IOException {
        GoodsMapper goodsMapper = SqlConnector.getSqlSession().getMapper(GoodsMapper.class);
        Goods goods= goodsMapper.selectGood(goodsNo, Table);
        System.out.println(goods.getGoodsSupply());
        Integer goodsSale = goodsMapper.selectGoodsSale(goodsNo);
        goods.setGoodsSale(goodsSale);
        return goods;
    }

    @Override
    public void removeGoods(String goodsNo) throws IOException {
        GoodsMapper goodsMapper = SqlConnector.getSqlSession().getMapper(GoodsMapper.class);
        goodsMapper.deleteGoods(goodsNo);
    }

    @Override
    public void addGoods(Goods goods) throws IOException {
        GoodsMapper goodsMapper = SqlConnector.getSqlSession().getMapper(GoodsMapper.class);
        goodsMapper.insertGoods(goods);
    }


}
