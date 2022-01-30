package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.labor.Employees;

import java.util.List;

public interface IEmployeesDao extends IBaseDao<Employees> {
    List<Employees> getAllEmployees(long id);
}
