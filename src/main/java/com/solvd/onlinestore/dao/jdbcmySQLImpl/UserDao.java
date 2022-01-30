package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IUserDao;
import com.solvd.onlinestore.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends AbstractMySQLDao<User> implements IUserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDao.class);

    public UserDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO user (first_name, middle_name," +
            "last_name, mobile, email, password, user_name, time_created, last_login) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, first_name, middle_name, " +
            "last_name, mobile, email, password, user_name, time_created, last_login FROM user WHERE id = ?";

    private static final String UPDATE = "UPDATE user SET first_name = ?, middle_name = ?, " +
            "last_name = ?, mobile = ?, email = ?, password = ?, user_name = ?, time_created = ?, last_login WHERE id = ?";

    private static final String DELETE = "DELETE FROM user WHERE id = ?";

    public UserDao() {
        super();
    }

    @Override
    public User findById(long id) {
        User user = new User();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setMiddleName(rs.getString("middle_name"));
                user.setLastName(rs.getString("last_name"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("user_name"));
                user.setTimeCreated(rs.getDate("time_created"));
                user.setLastLogin(rs.getDate("last_login"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User dto) {
        User user = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getMiddleName());
            statement.setString(3, dto.getLastName());
            statement.setString(4, dto.getMobile());
            statement.setString(5, dto.getEmail());
            statement.setString(6, dto.getPassword());
            statement.setString(7, dto.getUserName());
            statement.setDate(8, dto.getTimeCreated());
            statement.setDate(9,dto.getLastLogin());
            statement.setLong(10, dto.getId());
            statement.execute();
            user = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User create(User dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getMiddleName());
            statement.setString(3, dto.getLastName());
            statement.setString(4, dto.getMobile());
            statement.setString(5, dto.getEmail());
            statement.setString(6, dto.getPassword());
            statement.setString(7, dto.getUserName());
            statement.setDate(8, dto.getTimeCreated());
            statement.setDate(9,dto.getLastLogin());
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
    public List<User> getAllUsersByID(long id) {
        return null;
    }
}
