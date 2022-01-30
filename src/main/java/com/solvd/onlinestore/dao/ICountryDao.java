package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.location.Country;

import java.util.List;

public interface ICountryDao extends IBaseDao<Country> {
    List<Country> getCountryByID(long id);
}
