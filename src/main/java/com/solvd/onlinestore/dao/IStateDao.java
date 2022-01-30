package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.location.State;

import java.util.List;

public interface IStateDao extends IBaseDao<State> {
    List<State> getStateByID(long id);
}
