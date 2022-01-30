package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.purchase.Order;

public interface IOrderService<T> {
    Order getOrderById(long id);
}
