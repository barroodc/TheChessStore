package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.InvoiceDao;
import com.solvd.onlinestore.model.purchase.Invoice;
import com.solvd.onlinestore.services.interfaces.IInvoiceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvoiceService implements IInvoiceService<Invoice> {
    private static final Logger LOGGER = LogManager.getLogger(InvoiceService.class);
    private static final InvoiceDao invoiceDao;
    private static Invoice invoice;

    static {
        invoiceDao = new InvoiceDao();
        invoice = null;
    }

    @Override
    public Invoice getInvoiceById(long id) {
        try {
            invoice = (Invoice) invoiceDao.getAllInvoicesByID(id);
            LOGGER.info(invoice);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
