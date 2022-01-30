package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IOrderDao;
import com.solvd.onlinestore.model.purchase.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDao extends AbstractMySQLDao<Order> implements IOrderDao {
    private static final Logger LOGGER = LogManager.getLogger(OrderDao.class);


    public OrderDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO order (user_id, date_of_order, date_of_delivery, time_of_delivery, " +
            " postal_code, mobile, email, time_created, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, user_id, date_of_order, date_of_delivery, time_of_delivery," +
            " postal_code, mobile, email, time_created, status FROM order WHERE id = ?";

    private static final String UPDATE = "UPDATE order SET user_id = ?, date_of_order = ?, date_of_delivery = ?, time_of_delivery = ?, " +
            " postal_code = ?, mobile = ?, email = ?, time_created = ?, status = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM order WHERE id = ?";

    public OrderDao() {

    }

    @Override
    public Order findById(long id) {
        Order order = new Order();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                order.setId(rs.getLong("id"));
                order.setUserID(rs.getLong("user_id"));
                order.setDateOfOrder(rs.getDate("date_of_order"));
                order.setDateOfDelivery(rs.getDate("date_of_delivery"));
                order.setTimeOfDelivery(rs.getDate("time_of_delivery"));
                order.setPostalCode(rs.getString("postal_code"));
                order.setMobile(rs.getString("mobile"));
                order.setEmail(rs.getString("email"));
                order.setTimeCreated(rs.getDate("time_created"));
                order.setStatus(rs.getString("status"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        Order order = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setLong(1, dto.getUserID());
            statement.setDate(2, dto.getDateOfOrder());
            statement.setDate(3, dto.getDateOfDelivery());
            statement.setDate(4, dto.getTimeOfDelivery());
            statement.setString(5, dto.getMobile());
            statement.setString(6, dto.getEmail());
            statement.setDate(7, dto.getTimeCreated());
            statement.setString(8, dto.getStatus());
            statement.setLong(9, dto.getId());
            statement.execute();
            order = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return order;
    }

    @Override
    public Order create(Order dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dto.getUserID());
            statement.setDate(2, dto.getDateOfOrder());
            statement.setDate(3, dto.getDateOfDelivery());
            statement.setDate(4, dto.getTimeOfDelivery());
            statement.setString(5, dto.getMobile());
            statement.setString(6, dto.getEmail());
            statement.setDate(7, dto.getTimeCreated());
            statement.setString(8, dto.getStatus());
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
    public List<Order> getOrderByID(long id) {
        return null;
    }
}
