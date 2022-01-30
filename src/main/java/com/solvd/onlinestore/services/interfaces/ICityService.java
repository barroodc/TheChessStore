package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.location.City;

public interface ICityService<T> {
    City getCityByID(long id);
}
