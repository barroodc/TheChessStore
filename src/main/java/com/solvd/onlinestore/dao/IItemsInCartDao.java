package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.checkout.ItemsInCart;

import java.util.List;

public interface IItemsInCartDao extends IBaseDao<ItemsInCart> {
    List<ItemsInCart> getAllItemsByID(long id);
}
