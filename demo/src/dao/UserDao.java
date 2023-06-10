package dao;

import vo.User;

public interface UserDao {

    //用户注册
    int signUser(User user);
}
