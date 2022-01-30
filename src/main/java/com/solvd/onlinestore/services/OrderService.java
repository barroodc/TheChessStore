package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.OrderDao;
import com.solvd.onlinestore.model.purchase.Order;
import com.solvd.onlinestore.services.interfaces.IOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderService implements IOrderService<Order> {
    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);
    private static final OrderDao orderDao;
    private static Order order;

    static {
        orderDao = new OrderDao();
        order = null;
    }

    @Override
    public Order getOrderById(long id) {
        try {
            order = (Order) orderDao.getOrderByID(id);
            LOGGER.info(order);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
