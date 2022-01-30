package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.location.Address;

import java.util.List;

public interface IAddressDao extends IBaseDao<Address> {
    List<Address> getAddressByID(long id);
}
