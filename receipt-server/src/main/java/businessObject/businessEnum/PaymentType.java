package businessObject.businessEnum;

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
}
