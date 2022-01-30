package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.TransactionDao;
import com.solvd.onlinestore.model.purchase.Transaction;
import com.solvd.onlinestore.services.interfaces.ITransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionService implements ITransactionService<Transaction> {
    private static final Logger LOGGER = LogManager.getLogger(TransactionService.class);
    private static final TransactionDao transactionDao;
    private static Transaction transaction;

    static {
        transactionDao = new TransactionDao();
        transaction = null;
    }

    @Override
    public Transaction getTransactionServiceById(long id) {
        try {
            transaction = (Transaction) transactionDao.getAllTransactionsByID(id);
            LOGGER.info(transaction);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
