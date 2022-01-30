package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.checkout.ItemsInCart;

public interface IItemsInCartService<T> {
    ItemsInCart getItemsInCartById(long id);
}
