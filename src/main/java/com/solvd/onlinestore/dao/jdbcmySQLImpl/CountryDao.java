package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.ICountryDao;
import com.solvd.onlinestore.model.location.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CountryDao extends AbstractMySQLDao<Country> implements ICountryDao {
    private static final Logger LOGGER = LogManager.getLogger(CountryDao.class);

    public CountryDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO country (country_name, currency_name, phone_code, " +
            "last_update) VALUES (?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, country_name, currency_name, phone_code, " +
            "last_update FROM country WHERE id = ?";

    private static final String UPDATE = "UPDATE country SET country_name = ?, currency_name = ?, phone_code = ?, " +
            "last_update FROM country WHERE id = ?";

    private static final String DELETE = "DELETE FROM country WHERE id = ?";

    public CountryDao() {

    }

    @Override
    public Country findById(long id) {
        Country country = new Country();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                country.setId(rs.getLong("id"));
                country.setCountryName(rs.getString("country_name"));
                country.setCurrencyName(rs.getString("currency_name"));
                country.setPhoneCode(rs.getString("phone_code"));
                country.setLastUpdate(rs.getTimestamp("last_update"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return country;
    }

    @Override
    public List<Country> findAll() {
        return null;
    }

    @Override
    public Country update(Country dto) {
        Country country = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getCountryName());
            statement.setString(2, dto.getCurrencyName());
            statement.setString(3, dto.getPhoneCode());
            statement.setTimestamp(4, dto.getLastUpdate());
            statement.setLong(5, dto.getId());
            statement.execute();
            country = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return country;
    }

    @Override
    public Country create(Country dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getCountryName());
            statement.setString(2, dto.getCurrencyName());
            statement.setString(3, dto.getPhoneCode());
            statement.setTimestamp(4, dto.getLastUpdate());
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
    public List<Country> getCountryByID(long id) {
        return null;
    }
}
