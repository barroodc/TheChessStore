package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.product.ProductSupplier;

public interface IProductSupplierService<T> {
    ProductSupplier getProductSupplierById(long id);
}
