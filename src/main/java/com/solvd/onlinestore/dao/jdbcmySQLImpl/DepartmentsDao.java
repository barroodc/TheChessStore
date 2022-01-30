package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IDepartmentsDao;
import com.solvd.onlinestore.model.labor.Departments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentsDao extends AbstractMySQLDao<Departments> implements IDepartmentsDao {
    private static final Logger LOGGER = LogManager.getLogger(DepartmentsDao.class);


    public DepartmentsDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO departments (department_name) VALUES (?)";

    private static final String GET_ONE = "SELECT id, department_name FROM departments WHERE id = ?";

    private static final String UPDATE = "UPDATE departments SET department_name = ? FROM employees WHERE id = ?";

    private static final String DELETE = "DELETE FROM departments WHERE id = ?";

    public DepartmentsDao() {

    }

    @Override
    public Departments findById(long id) {
        Departments departments = new Departments();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                departments.setId(rs.getLong("id"));
                departments.setDepartmentName(rs.getString("department_name"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return departments;
    }

    @Override
    public List<Departments> findAll() {
        return null;
    }

    @Override
    public Departments update(Departments dto) {
        Departments departments = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getDepartmentName());
            statement.setLong(2, dto.getId());
            statement.execute();
            departments = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return departments;
    }

    @Override
    public Departments create(Departments dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getDepartmentName());
            statement.execute();
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Departments> getAllDepartments(long id) {
        return null;
    }
}
