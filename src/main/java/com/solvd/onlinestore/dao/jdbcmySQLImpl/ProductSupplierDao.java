package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IProductSupplierDao;
import com.solvd.onlinestore.model.product.ProductSupplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductSupplierDao extends AbstractMySQLDao<ProductSupplier> implements IProductSupplierDao {
    private static final Logger LOGGER = LogManager.getLogger(ProductSupplierDao.class);


    public ProductSupplierDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO product_supplier (supplier_name, category_of_products) VALUES (?, ?)";

    private static final String GET_ONE = "SELECT id, supplier_name, category_of_products FROM product_supplier WHERE id = ?";

    private static final String UPDATE = "UPDATE id SET supplier_name = ?, category_of_products = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM product_supplier WHERE id = ?";

    public ProductSupplierDao() {

    }

    @Override
    public ProductSupplier findById(long id) {
        ProductSupplier productSupplier = new ProductSupplier();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                productSupplier.setId(rs.getLong("id"));
                productSupplier.setSupplierName(rs.getString("supplier_name"));
                productSupplier.setCategoryOfProducts("category_of_products");
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return productSupplier;
    }

    @Override
    public List<ProductSupplier> findAll() {
        return null;
    }

    @Override
    public ProductSupplier update(ProductSupplier dto) {
        ProductSupplier productSupplier = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getSupplierName());
            statement.setString(2, dto.getCategoryOfProducts());
            statement.setLong(4, dto.getId());
            statement.execute();
            productSupplier = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return productSupplier;
    }

    @Override
    public ProductSupplier create(ProductSupplier dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getSupplierName());
            statement.setString(2,dto.getCategoryOfProducts());
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
    public List<ProductSupplier> getAllProductSuppliersByID(long id) {
        return null;
    }
}
