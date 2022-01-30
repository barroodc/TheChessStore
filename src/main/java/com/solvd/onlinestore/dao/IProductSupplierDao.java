package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.product.ProductSupplier;

import java.util.List;

public interface IProductSupplierDao extends IBaseDao<ProductSupplier> {
    List<ProductSupplier> getAllProductSuppliersByID(long id);
}
