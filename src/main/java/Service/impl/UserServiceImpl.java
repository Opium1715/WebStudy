package Service.impl;

import Bean.Business;
import Bean.User;
import Service.UserService;
import DAO.Mapper.UserMapper;
import Util.PageUtil.Pages;
import Util.SQL.SqlConnector;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //获取持久层连接
//    SqlSession sqlSession= SqlConnector.SqlInit();


    public UserServiceImpl() throws IOException {
    }


    @Override
    public<T> List<T> getUserList(int PageNo, String keyWord, String Type) throws IOException {
        SqlSession sqlSession = SqlConnector.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        if(Type.equals("User")){
            return (List<T>) userMapper.selectByPage(PageNo, keyWord);
        }
        else {
            return (List<T>) userMapper.selectBusByPage(PageNo, keyWord);
        }
    }

    @Override
    public void addUser(Object o, String Type) throws IOException {
        UserMapper userMapper=SqlConnector.getSqlSession().getMapper(UserMapper.class);
        if(Type.equals("User")){
            User user = (User) o;
            userMapper.insertDynamic(user);
        }
        else {
            Business business = (Business) o;
            userMapper.insertBusDynamic(business);
        }
    }

    @Override
    public Object getUserById(String No, String Type) throws IOException {
        UserMapper userMapper=SqlConnector.getSqlSession().getMapper(UserMapper.class);
        if(Type.equals("User")){
            return userMapper.selectById(No);
        }
        else {
            return userMapper.selectBusById(No);
        }
    }

    @Override
    public void delUser(String No, String Type) throws IOException {
        UserMapper userMapper=SqlConnector.getSqlSession().getMapper(UserMapper.class);
        if(Type.equals("User")){
             userMapper.deleteById(No);
        }
        else {
             userMapper.deleteBusById(No);
        }
    }

    @Override
    public int getTotalPages(String keyWord,String Type) throws IOException {
        UserMapper userMapper=SqlConnector.getSqlSession().getMapper(UserMapper.class);
        return Pages.TotalPage(userMapper.selectCount(keyWord, Type));
    }

    @Override
    public void updateUser(Object o, String Type) throws IOException {
        SqlSession sqlSession = SqlConnector.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        if(Type.equals("User")){
            User user = (User) o;
            userMapper.updateDynamic(user);
        }
        else {
            userMapper.updateBusDynamic((Business)o);
        }
    }
}
