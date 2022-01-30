package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.product.Product;

import java.util.List;

public interface IProductDao extends IBaseDao<Product> {
    List<Product> getProductByID(long id);
}
