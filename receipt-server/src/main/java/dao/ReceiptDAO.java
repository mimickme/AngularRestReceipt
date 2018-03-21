package dao;

import java.util.List;

import businessObject.Receipt;

public interface ReceiptDAO 
{
    List<Receipt> getAll();
    Receipt getById(long receiptId);
    boolean insertReceipt(Receipt receipt);
    boolean updateReceipt(Receipt receipt);
    boolean deleteReceipt(Receipt receipt);
}
