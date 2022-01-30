package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.product.ProductCategory;

import java.util.List;

public interface IProductCategoryDao extends IBaseDao<ProductCategory> {
    List<ProductCategory> getProductCategoryByID(long id);
}
