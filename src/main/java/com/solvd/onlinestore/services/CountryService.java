package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.CountryDao;
import com.solvd.onlinestore.model.location.Country;
import com.solvd.onlinestore.services.interfaces.ICountryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountryService implements ICountryService<Country> {
    private static final Logger LOGGER = LogManager.getLogger(CountryService.class);
    private static final CountryDao countryDao;
    private static Country country;

    static {
        countryDao = new CountryDao();
        country = null;
    }
    @Override
    public Country getCountryByID(long id) {
        try {
            country = (Country) countryDao.getCountryByID(id);
            LOGGER.info(country);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
