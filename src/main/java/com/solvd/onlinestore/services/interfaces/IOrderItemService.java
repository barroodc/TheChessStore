package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.purchase.OrderItem;

public interface IOrderItemService<T> {
    OrderItem getOrderItemById(long id);
}
