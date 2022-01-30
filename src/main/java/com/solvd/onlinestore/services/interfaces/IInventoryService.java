package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.product.Inventory;

public interface IInventoryService<T> {
    Inventory getInventoryById(long id);
}
