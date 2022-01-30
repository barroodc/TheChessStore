package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.product.ProductReview;

import java.util.List;

public interface IProductReviewDao extends IBaseDao<ProductReview> {
    List<ProductReview> getAllProductReviewsByID(long id);
}
