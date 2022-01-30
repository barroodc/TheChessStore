package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.OrderItemDao;
import com.solvd.onlinestore.model.purchase.OrderItem;
import com.solvd.onlinestore.services.interfaces.IOrderItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderItemService implements IOrderItemService<OrderItem> {
    private static final Logger LOGGER = LogManager.getLogger(OrderItemService.class);
    private static final OrderItemDao orderItemDao;
    private static OrderItem orderItem;

    static {
        orderItemDao = new OrderItemDao();
        orderItem = null;
    }

    @Override
    public OrderItem getOrderItemById(long id) {
        try {
            orderItem = (OrderItem) orderItemDao.getOrderItemByID(id);
            LOGGER.info(orderItem);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
