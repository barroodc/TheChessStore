package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.labor.Departments;

import java.util.List;

public interface IDepartmentsDao extends IBaseDao<Departments> {
    List<Departments> getAllDepartments(long id);
}
