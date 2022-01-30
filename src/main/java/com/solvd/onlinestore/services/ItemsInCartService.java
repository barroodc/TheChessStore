package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.ItemsInCartDao;
import com.solvd.onlinestore.model.checkout.ItemsInCart;
import com.solvd.onlinestore.services.interfaces.IItemsInCartService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItemsInCartService implements IItemsInCartService<ItemsInCart> {
    private static final Logger LOGGER = LogManager.getLogger(ItemsInCartService.class);
    private static final ItemsInCartDao itemsInCartDao;
    private static ItemsInCart itemsInCart;

    static {
        itemsInCartDao = new ItemsInCartDao();
        itemsInCart = null;
    }

    @Override
    public ItemsInCart getItemsInCartById(long id) {
        try {
            itemsInCart = (ItemsInCart) itemsInCartDao.getAllItemsByID(id);
            LOGGER.info(itemsInCart);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
