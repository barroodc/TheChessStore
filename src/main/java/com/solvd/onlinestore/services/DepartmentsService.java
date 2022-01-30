package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.DepartmentsDao;
import com.solvd.onlinestore.model.labor.Departments;
import com.solvd.onlinestore.services.interfaces.IDepartmentsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DepartmentsService implements IDepartmentsService<Departments> {
    private static final Logger LOGGER = LogManager.getLogger(DepartmentsService.class);
    private static final DepartmentsDao departmentsDao;
    private static Departments departments;

    static {
        departmentsDao = new DepartmentsDao();
        departments = null;
    }


    @Override
    public Departments getDepartmentById(long id) {
        try {
            departments = (Departments) departmentsDao.getAllDepartments(id);
            LOGGER.info(departments);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
