package com.solvd.onlinestore.dao;

import com.solvd.onlinestore.model.purchase.Invoice;

import java.util.List;

public interface IInvoiceDao extends IBaseDao<Invoice> {
    List<Invoice> getAllInvoicesByID(long id);
}
