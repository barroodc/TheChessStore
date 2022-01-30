package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.product.ProductCategory;

public interface IProductCategoryService<T> {
    ProductCategory getProductCategoryById(long id);
}
