package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.user.User;

public interface IUserService<T> {
    User getUserById(long id);
}
