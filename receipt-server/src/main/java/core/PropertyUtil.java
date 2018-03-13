package core;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigSyntax;

public class PropertyUtil 
{
    private static PropertyUtil instance = new PropertyUtil();
    
    private Config configs;

    private PropertyUtil()
    {
        String confLocation = System.getProperty("conf.location");
        if (confLocation == null)
        {        
            URL defaultConf = this.getClass().getResource("/default.conf");
            configs = ConfigFactory.parseURL(defaultConf);
        }
        else
        {
            configs = ConfigFactory.parseFile(new File(confLocation));
        }
    }
    
    public static String getDatabasePath()
    {
        return instance.configs.getString("databasePath");
    }
}
