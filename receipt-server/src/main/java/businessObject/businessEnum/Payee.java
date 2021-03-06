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
    
    public static Payee valueOf(int value)
    {
        switch (value)
        {
            case 1:
                return HONG;
            case 2:
                return JESSICA;
            case 3:
                return HOME;
            default:                
                return null;
        }
    }
}
