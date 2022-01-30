package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.product.Product;

public interface IProductService<T> {
    Product getProductById(long id);
}
