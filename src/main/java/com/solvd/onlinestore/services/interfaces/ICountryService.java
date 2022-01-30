package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.location.Country;

public interface ICountryService<T> {
    Country getCountryByID(long id);
}
