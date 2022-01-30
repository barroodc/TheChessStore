package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.user.User;

import java.util.List;

public interface IUserDao extends IBaseDao<User> {
    List<User> getAllUsersByID(long id);
}
