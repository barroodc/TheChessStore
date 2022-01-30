package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.ProductDao;
import com.solvd.onlinestore.model.product.Product;
import com.solvd.onlinestore.services.interfaces.IProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductService implements IProductService<Product> {
    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);
    private static final ProductDao productDao;
    private static Product product;

    static {
        productDao = new ProductDao();
        product = null;
    }


    @Override
    public Product getProductById(long id) {
        try {
            product = (Product) productDao.getProductByID(id);
            LOGGER.info(product);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
