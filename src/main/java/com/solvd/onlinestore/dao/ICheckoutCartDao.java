package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.checkout.CheckoutCart;

import java.util.List;

public interface ICheckoutCartDao extends IBaseDao<CheckoutCart> {
    List<CheckoutCart> getCheckoutCartByID(long id);
}
