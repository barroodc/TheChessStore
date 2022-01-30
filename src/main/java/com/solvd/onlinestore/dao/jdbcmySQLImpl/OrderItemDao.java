package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IOrderItemDao;
import com.solvd.onlinestore.model.purchase.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDao extends AbstractMySQLDao<OrderItem> implements IOrderItemDao {
    private static final Logger LOGGER = LogManager.getLogger(OrderItemDao.class);


    public OrderItemDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO order_item (order_id, product_id, sku, price, discount, quantity, time_created) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, order_id, product_id, sku, price, discount, quantity, time_created FROM order_item WHERE id = ?";

    private static final String UPDATE = "UPDATE order_item SET order_id = ?, product_id = ?, sku = ?, price = ?, discount = ?, quantity = ?, time_created = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM order_item WHERE id = ?";

    public OrderItemDao() {

    }

    @Override
    public OrderItem findById(long id) {
        OrderItem orderItem = new OrderItem();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                orderItem.setId(rs.getLong("id"));
                orderItem.setOrderID(rs.getLong("order_id"));
                orderItem.setProductID(rs.getLong("product_id"));
                orderItem.setSku(rs.getString("sku"));
                orderItem.setPrice(rs.getFloat("price"));
                orderItem.setDiscount(rs.getFloat("discount"));
                orderItem.setQuantity(rs.getLong("quantity"));
                orderItem.setTimeCreated(rs.getDate("time_created"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return orderItem;
    }

    @Override
    public List<OrderItem> findAll() {
        return null;
    }

    @Override
    public OrderItem update(OrderItem dto) {
        OrderItem orderItem = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setLong(1, dto.getOrderID());
            statement.setLong(2, dto.getProductID());
            statement.setString(3, dto.getSku());
            statement.setFloat(4, dto.getPrice());
            statement.setFloat(5, dto.getDiscount());
            statement.setLong(6, dto.getQuantity());
            statement.setDate(7, dto.getTimeCreated());
            statement.setLong(8, dto.getId());
            statement.execute();
            orderItem = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return orderItem;
    }

    @Override
    public OrderItem create(OrderItem dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dto.getOrderID());
            statement.setLong(2,dto.getProductID());
            statement.setString(3, dto.getSku());
            statement.setFloat(4, dto.getPrice());
            statement.setFloat(2,dto.getDiscount());
            statement.setLong(3, dto.getQuantity());
            statement.setDate(4, dto.getTimeCreated());
            statement.execute();
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e){
            LOGGER.error(e);
        }
    }


    @Override
    public List<OrderItem> getOrderItemByID(long id) {
        return null;
    }
}
