package rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController 
{
    @GetMapping("/receipts")
    public String getReceipts() 
    {
        return "heyhey test";
    }
}
