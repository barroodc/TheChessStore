package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IProductReviewDao;
import com.solvd.onlinestore.model.product.ProductReview;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductReviewDao extends AbstractMySQLDao<ProductReview> implements IProductReviewDao {
    private static final Logger LOGGER = LogManager.getLogger(ProductReviewDao.class);


    public ProductReviewDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO product_review (product_id, overall_rating, title, parent_id, time_created, user_review) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, product_id, overall_rating, title, parent_id, time_created, user_review FROM product_review WHERE id = ?";

    private static final String UPDATE = "UPDATE product_review SET product_id = ?, overall_rating = ?, title = ?, parent_id = ?, time_created = ? user_review = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM product_review WHERE id = ?";

    public ProductReviewDao() {

    }

    @Override
    public ProductReview findById(long id) {
        ProductReview productReview = new ProductReview();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                productReview.setId(rs.getLong("id"));
                productReview.setOverallRating(rs.getFloat("overall_rating"));
                productReview.setTitle(rs.getString("title"));
                productReview.setParentID(rs.getLong("parent_id"));
                productReview.setTimeCreated(rs.getDate("time_created"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return productReview;
    }

    @Override
    public List<ProductReview> findAll() {
        return null;
    }

    @Override
    public ProductReview update(ProductReview dto) {
        ProductReview productReview = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setFloat(1, dto.getOverallRating());
            statement.setString(2, dto.getTitle());
            statement.setLong(3, dto.getParentID());
            statement.setDate(4,dto.getTimeCreated());
            statement.setLong(4, dto.getId());
            statement.execute();
            productReview = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return productReview;
    }

    @Override
    public ProductReview create(ProductReview dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setFloat(1, dto.getOverallRating());
            statement.setString(2,dto.getTitle());
            statement.setLong(3, dto.getParentID());
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
    public List<ProductReview> getAllProductReviewsByID(long id) {
        return null;
    }
}
