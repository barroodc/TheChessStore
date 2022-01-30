package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IProductCategoryDao;
import com.solvd.onlinestore.model.product.ProductCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductCategoryDao extends AbstractMySQLDao<ProductCategory> implements IProductCategoryDao {
    private static final Logger LOGGER = LogManager.getLogger(ProductCategoryDao.class);


    public ProductCategoryDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO product_category (product_id, title, meta_title, product_name) VALUES (?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, product_id, title, meta_title, product_name FROM product_category WHERE id = ?";

    private static final String UPDATE = "UPDATE id SET product_id = ?, title = ?, meta_title = ?, product_name = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM product_category WHERE id = ?";

    public ProductCategoryDao() {

    }

    @Override
    public ProductCategory findById(long id) {
        ProductCategory productCategory = new ProductCategory();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                productCategory.setId(rs.getLong("id"));
                productCategory.setProductID(rs.getLong("product_id"));
                productCategory.setTitle(rs.getString("title"));
                productCategory.setMetaTitle(rs.getString("meta_title"));
                productCategory.setProductName(rs.getString("product_name"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return productCategory;
    }

    @Override
    public List<ProductCategory> findAll() {
        return null;
    }

    @Override
    public ProductCategory update(ProductCategory dto) {
        ProductCategory productCategory = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setLong(1, dto.getProductID());
            statement.setString(2, dto.getTitle());
            statement.setString(3, dto.getMetaTitle());
            statement.setString(4, dto.getProductName());
            statement.setLong(5, dto.getId());
            statement.execute();
            productCategory = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return productCategory;
    }

    @Override
    public ProductCategory create(ProductCategory dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dto.getProductID());
            statement.setString(2,dto.getTitle());
            statement.setString(3, dto.getMetaTitle());
            statement.setString(4, dto.getProductName());
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
    public List<ProductCategory> getProductCategoryByID(long id) {
        return null;
    }
}
