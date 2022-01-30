package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.product.Inventory;

import java.util.List;

public interface IInventoryDao extends IBaseDao<Inventory> {
    List<Inventory> getAllInventory(long id);
}
