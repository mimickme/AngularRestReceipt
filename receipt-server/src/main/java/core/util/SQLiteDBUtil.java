package core.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.SQLiteDataSource;
import org.sqlite.SQLiteJDBCLoader;

import core.PropertyUtil;

public class SQLiteDBUtil 
{
    Connection connection = null;
    
    final static Logger logger = LoggerFactory.getLogger(SQLiteDBUtil.class);
    
    private SQLiteDBUtil()
    {
        
    }
    
    public static SQLiteDBUtil getConnection()
    {
        SQLiteDBUtil sqLiteDBUtil = new SQLiteDBUtil();
        
        try
        {
            boolean initialize = SQLiteJDBCLoader.initialize();
        }
        catch (Exception e)
        {
            logger.error("Unable to initialize SQLiteJDBCLoader");
            logger.error(ExceptionUtils.getStackTrace(e));
            return null;
        }

        String dbUrl = "jdbc:sqlite:" + PropertyUtil.getDatabasePath();
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(dbUrl);
        
        Path dbObject = Paths.get(PropertyUtil.getDatabasePath());
        if (Files.exists(dbObject))
        {
            logger.info("Connecting to database at location '" + PropertyUtil.getDatabasePath() + "'");
            try 
            {                
                sqLiteDBUtil.connection = dataSource.getConnection();
                return sqLiteDBUtil;
            } 
            catch (SQLException e) 
            {                
                logger.error(ExceptionUtils.getStackTrace(e));
                return null;
            }
        }
        else
        {
            if (PropertyUtil.createNewDatabase())
            {
                logger.info("Creating new database created at location '" + PropertyUtil.getDatabasePath() + "'");
                try 
                {                    
                    sqLiteDBUtil.connection = dataSource.getConnection();
                    return sqLiteDBUtil;
                } 
                catch (SQLException e) 
                {                    
                    logger.error(ExceptionUtils.getStackTrace(e));
                    return null;
                }
            }
            else
            {
                logger.error("createNewDB option was flagged as false, no DB will be created");
                return null;
            }
        }
    }
    
    public PreparedStatement getPreparedStatement(String sql)
    {
        try 
        {
            return connection.prepareStatement(sql);
        } 
        catch (SQLException e) 
        {
            logger.error("Unable to generate prepared statement");
            logger.error(ExceptionUtils.getStackTrace(e));
            return null;
        }        
    }
    
}
