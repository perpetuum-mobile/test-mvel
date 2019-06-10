package com.egar.test;

/**
comment!

 * User: nchebykina
 * Date: 23.08.12
 * Time: 11:51
 */
public class Util {
    public static TradeContext getTradeContext(Trade t) {
        TradeContext tc = new TradeContext();
        tc.setBookId(t.getBookId());
        tc.setCtptId(t.getCtptId());
        tc.setDeliveryDate(t.getDeliveryDate());
        tc.setInstrumentClasses(t.getInstrumentClasses());
        tc.setInstrumentId(t.getInstrumentId());
        tc.setInstrumentTypeId(t.getInstrumentTypeId());
        tc.setIssuerCountryId(t.getIssuerCountryId());
        tc.setLowerDiscount(t.getLowerDiscount());
        tc.setPaymentCurrencyId(t.getPaymentCurrencyId());
        tc.setPaymentDate(t.getPaymentDate());
        tc.setPriceCurrencyId(t.getPriceCurrencyId());
        tc.setStatus(t.getStatus());
        tc.setTradeDate(t.getTradeDate());
        tc.setUpperDiscount(t.getUpperDiscount());
        return tc;
    }
}
