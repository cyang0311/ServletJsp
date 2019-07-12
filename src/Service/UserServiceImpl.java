package Service;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Pojo.User;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();
    //登录
    @Override
    public User checkUserLoginService(String uname, String pwd) {

        return userDao.checkUserLoginDao(uname,pwd);
    }
}
