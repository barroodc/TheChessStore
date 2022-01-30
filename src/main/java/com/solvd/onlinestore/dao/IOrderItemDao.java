package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.purchase.OrderItem;

import java.util.List;

public interface IOrderItemDao extends IBaseDao<OrderItem> {
    List<OrderItem> getOrderItemByID(long id);
}
