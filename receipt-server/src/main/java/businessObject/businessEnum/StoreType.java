package businessObject.businessEnum;

public enum StoreType 
{
    STORE(1),
    SERVICE(2);
    
    int value;
    
    StoreType(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public static StoreType valueOf(int value)
    {
        switch (value)
        {
            case 1:
                return STORE;
            case 2:
                return SERVICE;
            default:                
                return null;
        }
    }
}
