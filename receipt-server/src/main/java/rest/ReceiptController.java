package rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import businessObject.Receipt;
import core.PropertyUtil;

@RestController
@RequestMapping("/receipts")
public class ReceiptController 
{
    @GetMapping("/{receiptId}")
    public ResponseEntity<Receipt> getReceipt(@PathVariable long receiptId) 
    {
        Receipt result = new Receipt();
        result.setBaseAmount(new BigDecimal(100));
        String test = PropertyUtil.getDatabasePath();
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    public ResponseEntity<List<Receipt>> getReceipts()
    {
        
        
        return null;
    }
}
