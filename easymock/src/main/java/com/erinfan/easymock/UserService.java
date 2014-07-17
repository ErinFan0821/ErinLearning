package com.erinfan.easymock;

/**
 * Created by techops on 7/17/14.
 */
public class UserService {
    private UserDao userDao;

    public boolean registerUser(User user) {
        if (user.type.equals("vip")) {
            return userDao.insertUser(user);
        } else {
            System.out.println("Only vip can be registered!");
            return false;
        }
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
