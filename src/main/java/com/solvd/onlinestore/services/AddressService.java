package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.AddressDao;
import com.solvd.onlinestore.model.location.Address;
import com.solvd.onlinestore.services.interfaces.IAddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressService implements IAddressService<Address> {
    private static final Logger LOGGER = LogManager.getLogger(AddressService.class);
    private static final AddressDao addressDao;
    private static Address address;

    static {
        addressDao = new AddressDao();
        address = null;
    }

    @Override
    public Address getAddressByID(long id) {
        try {
            address = (Address) addressDao.getAddressByID(id);
            LOGGER.info(address);
        } catch (Exception e){
            LOGGER.error(e);
        }

        return null;
    }
}
