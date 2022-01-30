package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.EmployeesDao;
import com.solvd.onlinestore.model.labor.Employees;
import com.solvd.onlinestore.services.interfaces.IEmployeesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeesService implements IEmployeesService<Employees> {
    private static final Logger LOGGER = LogManager.getLogger(EmployeesService.class);
    private static final EmployeesDao employeesDao;
    private static Employees employees;

    static {
        employeesDao = new EmployeesDao();
        employees = null;
    }

    @Override
    public Employees getEmployeesById(long id) {
        try {
            employees = (Employees) employeesDao.getAllEmployees(id);
            LOGGER.info(employees);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
