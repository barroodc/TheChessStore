package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IAddressDao;
import com.solvd.onlinestore.model.location.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddressDao extends AbstractMySQLDao<Address> implements IAddressDao {

    private static final Logger LOGGER = LogManager.getLogger(AddressDao.class);

    public AddressDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO address (city_id, street_address, building_number, " +
            "last_update) VALUES (?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT id, city_id, street_address, building_number, last_update" +
            " FROM address WHERE id = ?";

    private static final String UPDATE = "UPDATE address SET city_id = ?, street_address = ?, building_number = ?, " +
            "last_update = ? FROM address WHERE id = ?";

    private static final String DELETE = "DELETE FROM address WHERE id = ?";

    public AddressDao() {

    }


    @Override
    public Address findById(long id) {
        Address address = new Address();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                address.setId(rs.getLong("id"));
                address.setCityID(rs.getLong("city_id"));
                address.setStreetAddress(rs.getString("street_address"));
                address.setBuildingNumber(rs.getString("building_number"));
                address.setLastUpdate(rs.getTimestamp("last_update"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return address;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address update(Address dto) {
        Address address = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setLong(1, dto.getCityID());
            statement.setString(2, dto.getStreetAddress());
            statement.setString(3, dto.getBuildingNumber());
            statement.setTimestamp(4, dto.getLastUpdate());
            statement.setLong(5, dto.getId());
            statement.execute();
            address = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return address;
    }

    @Override
    public Address create(Address dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dto.getCityID());
            statement.setString(2, dto.getStreetAddress());
            statement.setString(3, dto.getBuildingNumber());
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
    public List<Address> getAddressByID(long id) {
        return null;
    }
}
