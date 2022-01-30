package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.location.Address;

public interface IAddressService<T> {
    Address getAddressByID(long id);
}
