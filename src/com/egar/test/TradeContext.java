package com.egar.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: nchebykina
 * Date: 23.08.12
 * Time: 11:52
 */
public class TradeContext {
    private String type;
    private String status;
    private int ctptId;
    private int paymentCurrencyId;
    private int priceCurrencyId;
    private String instrumentTypeId;
    private int  instrumentId;
    private List<Integer> instrumentClasses = new ArrayList<Integer>();
    private int issuerCountryId;
    private int bookId;
    private BigDecimal lowerDiscount;
    private BigDecimal upperDiscount;
    private String tradeDate;
	private String paymentDate;
	private String deliveryDate;

    private java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCtptId() {
        return ctptId;
    }

    public void setCtptId(int ctptId) {
        this.ctptId = ctptId;
    }

    public int getPaymentCurrencyId() {
        return paymentCurrencyId;
    }

    public void setPaymentCurrencyId(int paymentCurrencyId) {
        this.paymentCurrencyId = paymentCurrencyId;
    }

    public int getPriceCurrencyId() {
        return priceCurrencyId;
    }

    public void setPriceCurrencyId(int priceCurrencyId) {
        this.priceCurrencyId = priceCurrencyId;
    }

    public String getInstrumentTypeId() {
        return instrumentTypeId;
    }

    public void setInstrumentTypeId(String instrumentTypeId) {
        this.instrumentTypeId = instrumentTypeId;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    public List<Integer> getInstrumentClasses() {
        return instrumentClasses;
    }

    public void setInstrumentClasses(List<Integer> instrumentClasses) {
        this.instrumentClasses = instrumentClasses;
    }

    public int getIssuerCountryId() {
        return issuerCountryId;
    }

    public void setIssuerCountryId(int issuerCountryId) {
        this.issuerCountryId = issuerCountryId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public BigDecimal getLowerDiscount() {
        return lowerDiscount;
    }

    public void setLowerDiscount(BigDecimal lowerDiscount) {
        this.lowerDiscount = lowerDiscount;
    }

    public BigDecimal getUpperDiscount() {
        return upperDiscount;
    }

    public void setUpperDiscount(BigDecimal upperDiscount) {
        this.upperDiscount = upperDiscount;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = format.format(tradeDate);
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = format.format(paymentDate);
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = format.format(deliveryDate);
    }
}
