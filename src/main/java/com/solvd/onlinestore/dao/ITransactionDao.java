package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.purchase.Transaction;

import java.util.List;

public interface ITransactionDao extends IBaseDao<Transaction> {
    List<Transaction> getAllTransactionsByID(long id);
}
