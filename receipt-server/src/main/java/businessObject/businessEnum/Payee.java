package businessObject.businessEnum;

public enum Payee 
{
    HONG(1),
    JESSICA(2),
    HOME(3);
    
    int value;
    
    Payee(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
}
