package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.purchase.Transaction;

public interface ITransactionService<T> {
    Transaction getTransactionServiceById(long id);
}
