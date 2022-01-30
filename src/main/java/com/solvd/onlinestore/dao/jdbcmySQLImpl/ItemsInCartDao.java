package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IItemsInCartDao;
import com.solvd.onlinestore.model.checkout.ItemsInCart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemsInCartDao extends AbstractMySQLDao<ItemsInCart> implements IItemsInCartDao {
    private static final Logger LOGGER = LogManager.getLogger(ItemsInCartDao.class);


    public ItemsInCartDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO items_in_cart (product_id, sku, " +
            "price, subtotal_of_items, discount, quantity, time_created, cart_updated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String GET_ONE = "SELECT id, product_id, sku, " +
            "price, subtotal_of_items, discount, quantity, time_created, cart_updated FROM items_in_cart WHERE id = ?";

    private static final String UPDATE = "UPDATE items_in_cart SET product_id = ?, " +
            "sku = ?, price = ?, subtotal_of_items = ?, discount = ?, quantity = ?, time_created = ?, cart_updated = ? FROM " +
            "items_in_cart  WHERE id = ?";

    private static final String DELETE = "DELETE FROM items_in_cart WHERE id = ?";

    public ItemsInCartDao() {

    }

    @Override
    public ItemsInCart findById(long id) {
        ItemsInCart itemsInCart = new ItemsInCart();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                itemsInCart.setId(rs.getLong("items_in_cart_id"));
                itemsInCart.setProductID(rs.getLong("product_id"));
                itemsInCart.setSku(rs.getString("sku"));
                itemsInCart.setPrice(rs.getFloat("price"));
                itemsInCart.setSubtotalOfItems(rs.getLong("subtotal_of_items"));
                itemsInCart.setDiscount(rs.getFloat("discount"));
                itemsInCart.setQuantity(rs.getFloat("quantity"));
                itemsInCart.setTimeCreated(rs.getDate("time_created"));
                itemsInCart.setCartUpdated(rs.getDate("cart_updated"));

            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return itemsInCart;
    }

    @Override
    public List<ItemsInCart> findAll() {
        return null;
    }

    @Override
    public ItemsInCart update(ItemsInCart dto) {
        ItemsInCart itemsInCart = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setLong(1, dto.getProductID());
            statement.setString(2, dto.getSku());
            statement.setFloat(3, dto.getPrice());
            statement.setFloat(4, dto.getSubtotalOfItems());
            statement.setFloat(5, dto.getDiscount());
            statement.setFloat(6, dto.getQuantity());
            statement.setDate(7, dto.getTimeCreated());
            statement.setDate(8, dto.getCartUpdated());
            statement.setLong(9, dto.getId());
            statement.execute();
            itemsInCart = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return itemsInCart;
    }

    @Override
    public ItemsInCart create(ItemsInCart dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dto.getProductID());
            statement.setString(2, dto.getSku());
            statement.setFloat(3, dto.getPrice());
            statement.setFloat(4, dto.getSubtotalOfItems());
            statement.setFloat(5, dto.getDiscount());
            statement.setFloat(6, dto.getQuantity());
            statement.setDate(7, dto.getTimeCreated());
            statement.setDate(8, dto.getCartUpdated());
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
    public List<ItemsInCart> getAllItemsByID(long id) {
        return null;
    }
}
