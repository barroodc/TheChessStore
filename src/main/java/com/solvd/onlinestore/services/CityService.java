package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.CityDao;
import com.solvd.onlinestore.model.location.City;
import com.solvd.onlinestore.services.interfaces.ICityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CityService implements ICityService<City> {
    private static final Logger LOGGER = LogManager.getLogger(CityService.class);
    private static final CityDao cityDao;
    private static City city;

    static {
        cityDao = new CityDao();
        city = null;
    }

    @Override
    public City getCityByID(long id) {
        try {
            city = (City) cityDao.getCityByID(id);
            LOGGER.info(city);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
