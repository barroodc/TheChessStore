package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.labor.Departments;

public interface IDepartmentsService<T> {
    Departments getDepartmentById(long id);
}
