package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.ProductCategoryDao;
import com.solvd.onlinestore.model.product.ProductCategory;
import com.solvd.onlinestore.services.interfaces.IProductCategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductCategoryService implements IProductCategoryService<ProductCategory> {
    private static final Logger LOGGER = LogManager.getLogger(ProductCategoryService.class);
    private static final ProductCategoryDao productCategoryDao;
    private static ProductCategory productCategory;

    static {
        productCategoryDao = new ProductCategoryDao();
        productCategory = null;
    }


    @Override
    public ProductCategory getProductCategoryById(long id) {
        try {
            productCategory = (ProductCategory) productCategoryDao.getProductCategoryByID(id);
            LOGGER.info(productCategory);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
