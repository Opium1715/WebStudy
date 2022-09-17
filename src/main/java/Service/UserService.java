package Service;

import Bean.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    <T> List<T> getUserList(int PageNo, String keyWord, String Type) throws IOException;
    void addUser(Object o, String Type) throws IOException;
    Object getUserById(String No, String Type) throws IOException;
    void delUser(String customerNo, String Type) throws IOException;
    int getTotalPages(String keyWord, String Type) throws IOException;
    void updateUser(Object o, String Type) throws IOException;
}