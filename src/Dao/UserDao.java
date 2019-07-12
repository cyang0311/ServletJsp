package Dao;

import Pojo.User;

public interface UserDao {
    User checkUserLoginDao(String uname,String pwd);
}
