package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.ICityDao;
import com.solvd.onlinestore.model.location.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDao extends AbstractMySQLDao<City> implements ICityDao {
    private static final Logger LOGGER = LogManager.getLogger(CityDao.class);

    public CityDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO city (country_id, city_name, location, " +
            "zip_code, last_update) VALUES (?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, country_id, city_name, location, zip_code," +
            "last_update FROM city WHERE id = ?";

    private static final String UPDATE = "UPDATE city SET country_id = ?, city_name = ?, location = ?, " +
            "zip_code = ?, last_update FROM city WHERE id = ?";

    private static final String DELETE = "DELETE FROM city WHERE id = ?";

    public CityDao() {

    }

    @Override
    public City findById(long id) {
        City city = new City();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                city.setId(rs.getLong("id"));
                city.setCountryID(rs.getLong("country_id"));
                city.setCity(rs.getString("city_name"));
                city.setLocation(rs.getBytes("location"));
                city.setZipCode(rs.getString("zip_code"));
                city.setLastUpdate(rs.getTimestamp("last_update"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return city;
    }

    @Override
    public List<City> findAll() {
        return  null;
    }

    @Override
    public City update(City dto) {
        City city = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setLong(1, dto.getCountryID());
            statement.setString(2, dto.getCityName());
            statement.setBytes(3, dto.getLocation());
            statement.setString(4,dto.getZipCode());
            statement.setTimestamp(5, dto.getLastUpdate());
            statement.setLong(5, dto.getId());
            statement.execute();
            city = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return city;
    }

    @Override
    public City create(City dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dto.getCountryID());
            statement.setString(2, dto.getCityName());
            statement.setBytes(3, dto.getLocation());
            statement.setString(4,dto.getZipCode());
            statement.setTimestamp(5, dto.getLastUpdate());
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
    public List<City> getCityByID(long id) {
        return null;
    }
}
