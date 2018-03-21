package rest;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import businessObject.Receipt;
import core.PropertyUtil;
import core.util.SQLiteDBUtil;
import dao.implement.sqlite.SQLiteReceiptDAO;

@RestController
@RequestMapping("/receipts")
public class ReceiptController 
{
    @GetMapping("/{receiptId}")
    public ResponseEntity<Receipt> getReceipt(@PathVariable long receiptId) 
    {   
        SQLiteReceiptDAO sqLiteReceiptDAO = new SQLiteReceiptDAO();
        Receipt result = sqLiteReceiptDAO.getById(receiptId);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    public ResponseEntity<List<Receipt>> getReceipts()
    {
        
        
        return null;
    }
}
