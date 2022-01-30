package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IBaseDao;

import java.sql.Connection;

public abstract class AbstractMySQLDao<T> implements IBaseDao<T> {
    protected Connection connection;

    public AbstractMySQLDao(Connection connection) {
        this.connection = connection;
    }

    public AbstractMySQLDao(){

    }
}
