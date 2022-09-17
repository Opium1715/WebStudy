package DAO.Mapper;

import Bean.Admin;
import Bean.Business;
import Bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    List<User> selectByPage(@Param("PageNo") int PageNo, @Param("keyWord") String keyWord);

    List<Business> selectBusByPage(int PageNo,String keyWord);

    void updateDynamic(User user);

    void updateBusDynamic(Business business);
    void insertDynamic(User user);

    void insertBusDynamic(Business business);
    void deleteById(String customerNo);

    void deleteBusById(String businessNo);

    int selectCount(String keyWord,String Table);

    User selectById(String No);

    Business selectBusById(String No);

    Admin selectAdminById(String AdminNo);
}
