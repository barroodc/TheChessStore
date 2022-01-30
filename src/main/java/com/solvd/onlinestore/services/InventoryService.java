package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.InventoryDao;
import com.solvd.onlinestore.model.product.Inventory;
import com.solvd.onlinestore.services.interfaces.IInventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InventoryService implements IInventoryService<Inventory> {
    private static final Logger LOGGER = LogManager.getLogger(InventoryService.class);
    private static final InventoryDao inventoryDao;
    private static Inventory inventory;

    static {
        inventoryDao = new InventoryDao();
        inventory = null;
    }

    @Override
    public Inventory getInventoryById(long id) {
        try {
            inventory = (Inventory) inventoryDao.getAllInventory(id);
            LOGGER.info(inventory);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
