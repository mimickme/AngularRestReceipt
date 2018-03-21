package businessObject.businessEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.implement.sqlite.SQLiteReceiptDAO;

public enum PaymentType 
{
    FREE(1),
    DEBIT(2),
    CREDIT(3),
    CASH(4);
    
    int value;
    
    PaymentType(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public static PaymentType valueOf(int value)
    {
        switch (value)
        {
            case 1:
                return FREE;
            case 2:
                return DEBIT;
            case 3:
                return CREDIT;
            case 4:
                return CASH;
            default:                
                return null;
        }
    }
}
