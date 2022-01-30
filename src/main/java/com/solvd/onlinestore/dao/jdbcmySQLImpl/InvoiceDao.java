package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.IInvoiceDao;
import com.solvd.onlinestore.model.purchase.Invoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InvoiceDao extends AbstractMySQLDao<Invoice> implements IInvoiceDao {
    private static final Logger LOGGER = LogManager.getLogger(InvoiceDao.class);


    public InvoiceDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO invoice (transaction_id, inventory_id, is_in_stock, " +
            "price, discount, pre_tax, tax, subtotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String GET_ONE = "SELECT id, transaction_id, inventory_id, is_in_stock, " +
            "price, discount, pre_tax, tax, subtotal FROM invoice WHERE invoice_id = ?";

    private static final String UPDATE = "UPDATE invoice SET transaction_id = ?, inventory_id = ?, is_in_stock = ?, " +
            "price = ?, discount = ?, pre_tax = ?, tax = ?, subtotal = ? FROM invoice  WHERE id = ?";


    private static final String DELETE = "DELETE FROM invoice WHERE id = ?";

    public InvoiceDao() {

    }

    @Override
    public Invoice findById(long id) {
        Invoice invoice = new Invoice();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                invoice.setId(rs.getLong("id"));
                invoice.setTransactionID(rs.getLong("transaction_id"));
                invoice.setInventoryID(rs.getLong("inventory_id"));
                invoice.setIsInStock(rs.getBytes("is_in_stock"));
                invoice.setPrice(rs.getFloat("price"));
                invoice.setDiscount(rs.getLong("discount"));
                invoice.setPreTax(rs.getFloat("pre_tax"));
                invoice.setTax(rs.getFloat("tax"));
                invoice.setSubtotal(rs.getFloat("subtotal"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return invoice;
    }

    @Override
    public List<Invoice> findAll() {
        return null;
    }

    @Override
    public Invoice update(Invoice dto) {
        Invoice invoice = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setLong(1, dto.getTransactionID());
            statement.setLong(2, dto.getInventoryID());
            statement.setBytes(3, dto.getIsInStock());
            statement.setFloat(4, dto.getPrice());
            statement.setFloat(5, dto.getDiscount());
            statement.setFloat(6, dto.getPreTax());
            statement.setFloat(7, dto.getTax());
            statement.setFloat(8, dto.getSubtotal());
            statement.setLong(9, dto.getId());
            statement.execute();
            invoice = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return invoice;
    }

    @Override
    public Invoice create(Invoice dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dto.getTransactionID());
            statement.setLong(2, dto.getInventoryID());
            statement.setBytes(3, dto.getIsInStock());
            statement.setFloat(4, dto.getPrice());
            statement.setFloat(5, dto.getDiscount());
            statement.setFloat(6, dto.getPreTax());
            statement.setFloat(7, dto.getTax());
            statement.setFloat(8, dto.getSubtotal());
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
    public List<Invoice> getAllInvoicesByID(long id) {
        return null;
    }
}
