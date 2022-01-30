package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IJobsDao;
import com.solvd.onlinestore.model.labor.Jobs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JobsDao extends AbstractMySQLDao<Jobs> implements IJobsDao {
    private static final Logger LOGGER = LogManager.getLogger(JobsDao.class);


    public JobsDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO jobs (job_title, min_salary, max_salary) VALUES (?, ?, ?);";

    private static final String GET_ONE = "SELECT id, job_title, min_salary, max_salary FROM jobs WHERE id = ?";

    private static final String UPDATE = "UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM jobs WHERE id = ?";

    public JobsDao() {

    }

    @Override
    public Jobs findById(long id) {
        Jobs jobs = new Jobs();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                jobs.setId(rs.getLong("id"));
                jobs.setJobTitle(rs.getString("job_title"));
                jobs.setMinSalary(rs.getFloat("min_salary"));
                jobs.setMaxSalary(rs.getFloat("max_salary"));

            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return jobs;
    }

    @Override
    public List<Jobs> findAll() {
        return null;
    }

    @Override
    public Jobs update(Jobs dto) {
        Jobs jobs = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getJobTitle());
            statement.setFloat(2, dto.getMinSalary());
            statement.setFloat(3, dto.getMaxSalary());
            statement.setLong(4, dto.getId());
            statement.execute();
            jobs = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return jobs;
    }

    @Override
    public Jobs create(Jobs dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getJobTitle());
            statement.setFloat(2, dto.getMinSalary());
            statement.setFloat(3, dto.getMaxSalary());
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
    public List<Jobs> getJobsByID(long id) {
        return null;
    }
}
