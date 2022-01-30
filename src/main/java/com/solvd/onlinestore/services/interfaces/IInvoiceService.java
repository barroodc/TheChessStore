package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.purchase.Invoice;

public interface IInvoiceService<T> {
    Invoice getInvoiceById(long id);
}
