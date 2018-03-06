package receipts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {
    @RequestMapping("/receipts")
    public String index() {
        return "heyhey test";
    }
}
