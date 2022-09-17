package Service;

import Bean.Business;

import java.io.IOException;

public interface LoginService {
    boolean judgeLogin(String AdminNo,String AdminPassword) throws IOException;


    Business getBus(String No) throws IOException;
}
