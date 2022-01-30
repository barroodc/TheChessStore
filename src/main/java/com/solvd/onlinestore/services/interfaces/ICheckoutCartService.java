package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.checkout.CheckoutCart;

public interface ICheckoutCartService<T> {
    CheckoutCart getCheckoutCartById(long id) throws Exception;
}
