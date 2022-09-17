package Service.impl;

import Bean.Admin;
import Bean.Business;
import DAO.Mapper.UserMapper;
import Service.LoginService;
import Util.SQL.SqlConnector;

import java.io.IOException;

public class LoginServiceImpl implements LoginService {



    public LoginServiceImpl() {
    }

    @Override
    public boolean judgeLogin(String AdminNo, String AdminPassword) throws IOException {
        UserMapper userMapper = SqlConnector.getSqlSession().getMapper(UserMapper.class);
        Admin admin = userMapper.selectAdminById(AdminNo);
        Business business = userMapper.selectBusById(AdminNo);
        if(admin!=null){
            return admin.getAdminNo().equals(AdminNo) && admin.getAdminPassWord().equals(AdminPassword);
        }
        else if(business!=null){
            return business.getBusinessNo().equals(AdminNo) && business.getPassWord().equals(AdminPassword);
        }
        else return false;
    }
    @Override
    public Business getBus(String No) throws IOException {
        UserMapper userMapper = SqlConnector.getSqlSession().getMapper(UserMapper.class);
        return userMapper.selectBusById(No);
    }

}
