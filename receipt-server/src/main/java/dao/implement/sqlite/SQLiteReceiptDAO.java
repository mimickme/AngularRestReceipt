package dao.implement.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.SQLiteDataSource;

import businessObject.Receipt;
import businessObject.businessEnum.Payee;
import businessObject.businessEnum.PaymentType;
import core.util.SQLiteDBUtil;
import dao.ReceiptDAO;

public class SQLiteReceiptDAO implements ReceiptDAO 
{
    final static Logger logger = LoggerFactory.getLogger(SQLiteReceiptDAO.class);
    
    SQLiteDBUtil sqLiteDBUtil;
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"); 
    
    public SQLiteReceiptDAO() 
    {
        sqLiteDBUtil = SQLiteDBUtil.getConnection();
    }

    @Override
    public List<Receipt> getAll() 
    {
        ArrayList<Receipt> result = new ArrayList<>();
        String sql = "SELECT * FROM RECEIPT";        
        PreparedStatement stmt = sqLiteDBUtil.getPreparedStatement(sql);
        
        try 
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Receipt r = new Receipt(rs.getLong("RECEIPTID"), 
                                        rs.getLong("STOREID"),
                                        LocalDate.parse(rs.getString("RECEIPTDATE"),dateTimeFormatter),
                                        PaymentType.valueOf(rs.getInt("PAYMENTTYPE")), 
                                        rs.getBigDecimal("BASEAMOUNT"), 
                                        rs.getBigDecimal("TAXAMOUNT"), 
                                        rs.getBigDecimal("TAXPERCENTAGE"), 
                                        rs.getBigDecimal("TIPAMOUNT"), 
                                        rs.getBigDecimal("TOTALAMOUNT"), 
                                        rs.getBigDecimal("ROUNDAMOUNT"), 
                                        rs.getBoolean("REVERSAL"), 
                                        Payee.valueOf(rs.getInt("PAYEE")));
                
                result.add(r);
            }
        } 
        catch (SQLException e) 
        {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        
        return result;
    }

    @Override
    public Receipt getById(long receiptId) 
    {
        Receipt result = new Receipt();
        
        String sql = "SELECT * FROM RECEIPT WHERE RECEIPTID = ?";
        PreparedStatement stmt = sqLiteDBUtil.getPreparedStatement(sql);
        
        try 
        {
            stmt.setLong(1, receiptId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                result = new Receipt(rs.getLong("RECEIPTID"), 
                                        rs.getLong("STOREID"),
                                        LocalDate.parse(rs.getString("RECEIPTDATE"),dateTimeFormatter),
                                        PaymentType.valueOf(rs.getInt("PAYMENTTYPE")), 
                                        rs.getBigDecimal("BASEAMOUNT"), 
                                        rs.getBigDecimal("TAXAMOUNT"), 
                                        rs.getBigDecimal("TAXPERCENTAGE"), 
                                        rs.getBigDecimal("TIPAMOUNT"), 
                                        rs.getBigDecimal("TOTALAMOUNT"), 
                                        rs.getBigDecimal("ROUNDAMOUNT"), 
                                        rs.getBoolean("REVERSAL"), 
                                        Payee.valueOf(rs.getInt("PAYEE")));
            }
        } 
        catch (SQLException e) 
        {
            logger.error(ExceptionUtils.getStackTrace(e));
        }        
        
        return result;
    }

    @Override
    public boolean insertReceipt(Receipt receipt) 
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateReceipt(Receipt receipt) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteReceipt(Receipt receipt) {
        // TODO Auto-generated method stub
        return false;
    }

}
