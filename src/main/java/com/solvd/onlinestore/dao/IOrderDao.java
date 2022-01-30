package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.purchase.Order;

import java.util.List;

public interface IOrderDao extends IBaseDao<Order> {
    List<Order> getOrderByID(long id);
}
