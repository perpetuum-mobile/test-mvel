package com.egar.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

/**
 * User: nchebykina
 * Date: 01.08.12
 * Time: 13:55
 */

public class Trade {
    private String type; //-- �������� AA, BB, CC, DD, EE, FF
    private String status; //-- �������� U, V, W, X, Y, Z
    private int ctptId; //-- �������� 1 ... 1000
    private int paymentCurrencyId; //-- �������� 1 ... 10
    private int priceCurrencyId; //-- �������� 1 ... 10
    private String instrumentTypeId; //-- �������� B, E, F, O
    private int  instrumentId; //-- �������� 1 ... 50
    private List<Integer> instrumentClasses = new ArrayList<Integer>(); //--  (��� �������� - 1 ��������) ������ ������ 3-5 ������ ��������� �� ���������� 1 ... 10
    private int issuerCountryId; //-- �������� 1 ... 5
    private int bookId; //-- �������� 1 ... 5
    private BigDecimal lowerDiscount; //-- �������� 0.0 ... 2.0 � ����� 0.01
    private BigDecimal upperDiscount; //-- �������� 0.0 ... 2.0 � ����� 0.01
    /**
	 * Дата заключения сделки
	 */
	private Date tradeDate;

	/**
	 * Дата расчетов по сделке
	 */
	private Date paymentDate;

	/**
	 * Дата поставки по сделке
	 */
	private Date deliveryDate;

    public Trade() {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        try{
            tradeDate = format.parse("2012-08-09");
            paymentDate = format.parse("2012-08-10");
            deliveryDate = format.parse("2012-08-11");
        } catch (Exception e) {
            e.printStackTrace();
        }

        type = Constants.types[(int)(Math.random() * 6)];
        status = Constants.statuses[(int)(Math.random() * 6)];
        ctptId = 1 + (int)(Math.random() * 1000);
        paymentCurrencyId = 1 + (int)(Math.random() * 10);
        priceCurrencyId = 1 + (int)(Math.random() * 10);
        instrumentTypeId = Constants.instrumentTypeIds[(int)(Math.random() * 4)];
        instrumentId = 1 + (int)(Math.random() * 50);
        issuerCountryId = 1 + (int)(Math.random() * 5);
        bookId = 1 + (int)(Math.random() * 5);
        HashSet<Integer> set = Constants.getRandoms(1, 10, 3 + (int)(Math.random() * 3));
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            instrumentClasses.add(it.next());
        }
        //instrumentClasses = 1 + (int)(Math.random() * 10);
        int num = (int)(Math.random() * 201);
        lowerDiscount = new BigDecimal(num/100.0, new MathContext(2, RoundingMode.HALF_EVEN));
        num = (int)(Math.random() * 201);
        upperDiscount = new BigDecimal(num/100.0, new MathContext(2, RoundingMode.HALF_EVEN));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\ntype                ");
        sb.append(type);
        sb.append("\nstatus              ");
        sb.append(status);
        sb.append("\nctptId              ");
        sb.append(ctptId);
        sb.append("\npaymentCurrencyId   ");
        sb.append(paymentCurrencyId);
        sb.append("\npriceCurrencyId     ");
        sb.append(priceCurrencyId);
        sb.append("\ninstrumentTypeId    ");
        sb.append(instrumentTypeId);
        sb.append("\ninstrumentId        ");
        sb.append(instrumentId);
        sb.append("\ninstrumentClasses   ");
        sb.append(instrumentClasses);
        sb.append("\nissuerCountryId     ");
        sb.append(issuerCountryId);
        sb.append("\nbookId              ");
        sb.append(bookId);
        sb.append("\nlowerDiscount       ");
        sb.append(lowerDiscount);
        sb.append("\nupperDiscount       ");
        sb.append(upperDiscount);
        return sb.toString();
    }
    /*
    * ������� ����������� �������
    * */
    public boolean cross(List<Integer> l) {
        for(Integer i: l)
            for (Integer j: instrumentClasses) if (i.equals(j)) return true;
        return false;
    }

    public String getTrdaeDateStr() {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
        return format.format(tradeDate);
    }

    public String getPaymentDateSte() {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
        return format.format(paymentDate);
    }

    public String getDeliveryDateStr() {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
        return format.format(deliveryDate);
    }

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

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
