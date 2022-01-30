package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.UserDao;
import com.solvd.onlinestore.model.user.User;
import com.solvd.onlinestore.services.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService implements IUserService<User> {
    private static final Logger LOGGER = LogManager.getLogger(User.class);
    private static final UserDao userDao;
    private static User user;

    static {
        userDao = new UserDao();
        user = null;
    }

    @Override
    public User getUserById(long id) {
        try {
            user = (User) userDao.getAllUsersByID(id);
            LOGGER.info(user);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
