package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.ProductReviewDao;
import com.solvd.onlinestore.model.product.ProductReview;
import com.solvd.onlinestore.services.interfaces.IProductReviewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductReviewService implements IProductReviewService<ProductReview> {
    private static final Logger LOGGER = LogManager.getLogger(ProductReviewService.class);
    private static final ProductReviewDao productReviewDao;
    private static ProductReview productReview;

    static {
        productReviewDao = new ProductReviewDao();
        productReview = null;
    }

    @Override
    public ProductReview getProductReviewById(long id) {
        try {
            productReview = (ProductReview) productReviewDao.getAllProductReviewsByID(id);
            LOGGER.info(productReview);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
