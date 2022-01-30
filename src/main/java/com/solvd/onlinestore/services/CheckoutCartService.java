package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.CheckoutCartDao;
import com.solvd.onlinestore.model.checkout.CheckoutCart;
import com.solvd.onlinestore.services.interfaces.ICheckoutCartService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutCartService implements ICheckoutCartService<CheckoutCart> {
    private static final Logger LOGGER = LogManager.getLogger(CheckoutCartService.class);
    private static final CheckoutCartDao checkoutCartDao;
    private static CheckoutCart checkoutCart;

    static {
        checkoutCartDao = new CheckoutCartDao();
        checkoutCart = null;
    }

    @Override
    public CheckoutCart getCheckoutCartById(long id) {
        try {
            checkoutCart = (CheckoutCart) checkoutCartDao.getCheckoutCartByID(id);
            LOGGER.info(checkoutCart);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;

    }

}
