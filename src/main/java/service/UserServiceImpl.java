package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
