package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.location.City;

import java.util.List;

public interface ICityDao extends IBaseDao<City> {
    List<City> getCityByID(long id);
}
