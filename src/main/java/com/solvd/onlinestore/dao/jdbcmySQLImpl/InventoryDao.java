package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IInventoryDao;
import com.solvd.onlinestore.model.product.Inventory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InventoryDao extends AbstractMySQLDao<Inventory> implements IInventoryDao {
    private static final Logger LOGGER = LogManager.getLogger(InventoryDao.class);


    public InventoryDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO inventory (product_name, description, price, amount_in_stock VALUES (?, ?, ?, ?, ?);";

    private static final String GET_ONE = "SELECT id, product_name, description, price, amount_in_stock subtotal FROM inventory WHERE id = ?";

    private static final String UPDATE = "UPDATE inventory SET product_name = ?, description = ?, price = ?, amount_in_stock = ? FROM inventory WHERE id = ?";

    private static final String DELETE = "DELETE FROM inventory WHERE id = ?";

    public InventoryDao() {

    }

    @Override
    public Inventory findById(long id) {
        Inventory inventory = new Inventory();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                inventory.setId(rs.getLong("id"));
                inventory.setProductName(rs.getString("product_name"));
                inventory.setDescription(rs.getString("description"));
                inventory.setPrice(rs.getFloat("price"));
                inventory.setAmountInStock(rs.getLong("amount_in_stock"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return inventory;
    }

    @Override
    public List<Inventory> findAll() {
        return null;
    }

    @Override
    public Inventory update(Inventory dto) {
        Inventory inventory = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getProductName());
            statement.setString(2, dto.getDescription());
            statement.setFloat(3, dto.getPrice());
            statement.setLong(4, dto.getAmountInStock());
            statement.setLong(5, dto.getId());
            statement.execute();
            inventory = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return inventory;
    }

    @Override
    public Inventory create(Inventory dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getProductName());
            statement.setString(2, dto.getDescription());
            statement.setFloat(3, dto.getPrice());
            statement.setLong(4, dto.getAmountInStock());
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
    public List<Inventory> getAllInventory(long id) {
        return null;
    }
}
