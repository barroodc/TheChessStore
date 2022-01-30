package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.ProductSupplierDao;
import com.solvd.onlinestore.model.product.ProductSupplier;
import com.solvd.onlinestore.services.interfaces.IProductSupplierService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductSupplierService implements IProductSupplierService<ProductSupplier> {
    private static final Logger LOGGER = LogManager.getLogger(ProductSupplierService.class);
    private static final ProductSupplierDao productSupplierDao;
    private static ProductSupplier productSupplier;

    static {
        productSupplierDao = new ProductSupplierDao();
        productSupplier = null;
    }

    @Override
    public ProductSupplier getProductSupplierById(long id) {
        try {
            productSupplier = (ProductSupplier) productSupplierDao.getAllProductSuppliersByID(id);
            LOGGER.info(productSupplier);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
