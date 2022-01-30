package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.labor.Employees;

public interface IEmployeesService<T> {
    Employees getEmployeesById(long id);
}
