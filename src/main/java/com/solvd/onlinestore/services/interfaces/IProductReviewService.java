package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.product.ProductReview;

public interface IProductReviewService<T> {
    ProductReview getProductReviewById(long id);
}
