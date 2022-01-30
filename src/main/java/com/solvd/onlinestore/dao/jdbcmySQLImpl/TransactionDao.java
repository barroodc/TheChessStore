package com.solvd.onlinestore.dao.jdbcmySQLImpl;

import com.solvd.onlinestore.dao.ITransactionDao;
import com.solvd.onlinestore.model.purchase.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransactionDao extends AbstractMySQLDao<Transaction> implements ITransactionDao {
    private static final Logger LOGGER = LogManager.getLogger(TransactionDao.class);


    public TransactionDao(Connection connection) {
        super(connection);
    }

    private static final String INSERT = "INSERT INTO transaction (status, time_created," +
            "approval_status) VALUES (?, ?, ?)";

    private static final String GET_ONE = "SELECT id, status, time_created, " +
            "approval_status FROM transaction WHERE id = ?";

    private static final String UPDATE = "UPDATE transaction SET status = ?, time_created = ?, " +
            "approval_status = ? WHERE id = ?";

    private static final String DELETE = "DELETE FROM transaction WHERE id = ?";

    public TransactionDao() {

    }

    @Override
    public Transaction findById(long id) {
        Transaction transaction = new Transaction();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                transaction.setId(rs.getLong("id"));
                transaction.setStatus(rs.getString("status"));
                transaction.setTimeCreated(rs.getDate("time_created"));
                transaction.setApprovalStatus(rs.getString("approval_status"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public Transaction update(Transaction dto) {
        Transaction transaction = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getStatus());
            statement.setDate(2,dto.getTimeCreated());
            statement.setString(3,dto.getApprovalStatus());
            statement.setLong(4, dto.getId());
            statement.execute();
            transaction = this.findById(dto.getId());
        }catch(SQLException e){
            LOGGER.error(e);
        }
        return transaction;
    }

    @Override
    public Transaction create(Transaction dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getStatus());
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
    public List<Transaction> getAllTransactionsByID(long id) {
        return null;
    }
}
