package businessObject;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import businessObject.businessEnum.Payee;
import businessObject.businessEnum.PaymentType;

public class Receipt 
{
    long receiptId;
    long storechainId;
    DateTime receiptDate;
    PaymentType paymentType;
    BigDecimal baseAmount;
    BigDecimal taxAmount;
    BigDecimal taxPercentage;
    BigDecimal tipAmount;
    BigDecimal totalAmount;
    BigDecimal roundAmount;
    boolean reversal;
    Payee payee;
    
    public Receipt()
    {
        
    }
    
    public Receipt(long receiptId, long storechainId, DateTime receiptDate, PaymentType paymentType, BigDecimal baseAmount,
            BigDecimal taxAmount, BigDecimal taxPercentage, BigDecimal tipAmount, BigDecimal totalAmount,
            BigDecimal roundAmount, boolean reversal, Payee payee) 
    {
        this.receiptId = receiptId;
        this.storechainId = storechainId;
        this.receiptDate = receiptDate;
        this.paymentType = paymentType;
        this.baseAmount = baseAmount;
        this.taxAmount = taxAmount;
        this.taxPercentage = taxPercentage;
        this.tipAmount = tipAmount;
        this.totalAmount = totalAmount;
        this.roundAmount = roundAmount;
        this.reversal = reversal;
        this.payee = payee;
    }

    public Long getReceiptId()
    {
        return receiptId;
    }    

    public long getStoreChainId() {
        return storechainId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="UTC")
    public DateTime getReceiptDate() {
        return receiptDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getRoundAmount() {
        return roundAmount;
    }

    public boolean isReversal() {
        return reversal;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public void setStoreChainId(long storechainId) {
        this.storechainId = storechainId;
    }

    public void setReceiptDate(DateTime receiptDate) {
        this.receiptDate = receiptDate;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    

    public void setBaseAmount(BigDecimal baseAmount)
    {
        this.baseAmount = baseAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public void setTipAmount(BigDecimal tipAmount) {
        this.tipAmount = tipAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setRoundAmount(BigDecimal roundAmount) {
        this.roundAmount = roundAmount;
    }

    public void setReversal(boolean reversal) {
        this.reversal = reversal;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }
}
