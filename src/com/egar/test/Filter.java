package com.egar.test;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Iterator;

/**
 * User: nchebykina
 * Date: 01.08.12
 * Time: 15:44
 */
public class Filter {

    public static long cntId = 0;

    private long id;
    private long filterType;
    private Serializable compiledExpr;

//Filter 0    type in ({AA}, {BB}) AND ctptId in ({1}, {2}, {3}, ..., {20}) AND instrumentTypeId in ({B}, {E}) AND instrumentClasses contains ({1}, {2}, {3})
//Filter 1    type = {CC} AND ctptId = {1} AND instrumentTypeId in ({F}, {O}) AND instrumentClasses contains ({1}, {2}, {3}) AND issuerCountryId = {1}
//Filter 2    type = {CC} AND ctptId = {1} instrumentClasses contains ({1}, {2}, {3}) AND (paymentCurrencyId = {1} OR priceCurrencyId = {1})
//Filter 3    bookId = {2} AND instrumentTypeId IN ('F', 'B') AND status IN ({U}, {V}, {X}, {Y})
//Filter 4    type not in ({AA}, {EE}) AND lowerDiscount >= 0.5 AND upperDiscount <= 1.5 AND bookId = {4}

    public Filter(int fType) {
        id = cntId++;
        filterType = fType + 1;
        switch (fType) {
            case 0:
                createExpr1();
                break;
            case 1:
                createExpr2();
                break;
            case 2:
                createExpr3();
                break;
            case 3:
                createExpr4();
                break;
            case 4:
                createExpr5();
                break;
            default:
                break;
        }
    }

    private void createExpr1() {
        StringBuilder sb = new StringBuilder();
        sb.append("({");
        sb.append(Constants.typePairs[(int)(Math.random()*15)]);
        sb.append("} contains type) && ([");
        HashSet<Integer> set = Constants.getRandoms(1, 1000, 20);
        Iterator<Integer> it = set.iterator();
        for(int i = 0; i < 19; i++){
            sb.append(it.next());
            sb.append(", ");
        }
        sb.append(it.next());
        sb.append("] contains ctptId) && ([");
        sb.append(Constants.instrumentTypeIdPairs[(int)(Math.random()*6)]);
        sb.append("] contains instrumentTypeId) && cross([");
        set = Constants.getRandoms(1, 10, 3);
        it = set.iterator();
        sb.append(it.next());
        sb.append(", ");
        sb.append(it.next());
        sb.append(", ");
        sb.append(it.next());
        sb.append("]) && lowerDiscount >= ");
        int num = (int)(Math.random() * 201);
        sb.append(new BigDecimal(num/100.0, new MathContext(2, RoundingMode.HALF_EVEN)));

//    System.out.println(sb.toString());
        //expr = sb.toString();
        compiledExpr = MVEL.compileExpression(sb.toString());
    }

    private void createExpr2() {
        StringBuilder sb = new StringBuilder();
        sb.append("type == \"");
        sb.append(Constants.types[(int)(Math.random() * 6)]);
        sb.append("\" && ctptId == ");
        sb.append(1 + (int)(Math.random() * 1000));
        sb.append(" && ([");
        sb.append(Constants.instrumentTypeIdPairs[(int)(Math.random()*6)]);
        sb.append("] contains instrumentTypeId) && cross([");
        HashSet<Integer> set = Constants.getRandoms(1, 10, 3);
        Iterator<Integer> it = set.iterator();
        sb.append(it.next());
        sb.append(", ");
        sb.append(it.next());
        sb.append(", ");
        sb.append(it.next());
        sb.append("]) && issuerCountryId == ");
        sb.append(1 + (int)(Math.random() * 5));

//    System.out.println(sb.toString());
        //expr = sb.toString();
        compiledExpr = MVEL.compileExpression(sb.toString());
    }

    private void createExpr3() {
        StringBuilder sb = new StringBuilder();
        sb.append("type == \"");
        sb.append(Constants.types[(int)(Math.random() * 6)]);
        sb.append("\" && ctptId == ");
        sb.append(1 + (int)(Math.random() * 1000));
        sb.append(" && cross([");
        HashSet<Integer> set = Constants.getRandoms(1, 10, 3);
        Iterator<Integer> it = set.iterator();
        sb.append(it.next());
        sb.append(", ");
        sb.append(it.next());
        sb.append(", ");
        sb.append(it.next());
        sb.append("]) && (paymentCurrencyId == ");
        sb.append(1 + (int)(Math.random() * 10));
        sb.append("|| priceCurrencyId == ");
        sb.append(1 + (int)(Math.random() * 10));
        sb.append(")");

//    System.out.println(sb.toString());
        //expr = sb.toString();
        compiledExpr = MVEL.compileExpression(sb.toString());
    }


    private void createExpr4() {
        StringBuilder sb = new StringBuilder();
        sb.append("bookId == ");
        sb.append(1 + (int)(Math.random() * 5));
        sb.append(" && ([");
        sb.append(Constants.instrumentTypeIdPairs[(int)(Math.random()*6)]);
        sb.append("] contains instrumentTypeId) && ([\"");
        HashSet<Integer> set = Constants.getRandoms(0, 5, 4);
        Iterator<Integer> it = set.iterator();
        sb.append(Constants.statuses[it.next()]);
        sb.append("\", \"");
        sb.append(Constants.statuses[it.next()]);
        sb.append("\", \"");
        sb.append(Constants.statuses[it.next()]);
        sb.append("\", \"");
        sb.append(Constants.statuses[it.next()]);
        sb.append("\"] contains status) && (paymentCurrencyId == ");
        sb.append(1 + (int)(Math.random() * 10));
        sb.append("|| priceCurrencyId == ");
        sb.append(1 + (int)(Math.random() * 10));
        sb.append(")");

//        System.out.println(sb.toString());
        //expr = sb.toString();
        compiledExpr = MVEL.compileExpression(sb.toString());
    }
    private void createExpr5() {
        StringBuilder sb = new StringBuilder();
        sb.append("!([");
        sb.append(Constants.typePairs[(int)(Math.random()*15)]);
        sb.append("] contains type) && lowerDiscount >= ");
        int num = (int)(Math.random() * 201);
        sb.append(new BigDecimal(num/100.0, new MathContext(2, RoundingMode.HALF_EVEN)));
        sb.append(" && upperDiscount <= ");
        num = (int)(Math.random() * 201);
        sb.append(new BigDecimal(num/100.0, new MathContext(2, RoundingMode.HALF_EVEN)));
        sb.append(" && bookId == ");
        sb.append(1 + (int)(Math.random() * 5));
        sb.append(" && ([");
        sb.append(Constants.instrumentTypeIdPairs[(int)(Math.random()*6)]);
        sb.append("] contains instrumentTypeId)");

//        System.out.println(sb.toString());
        //expr = sb.toString();
        compiledExpr = MVEL.compileExpression(sb.toString());
    }

    public long getId() {
        return id;
    }

    public Serializable getCompiledExpr() {
        return compiledExpr;
    }

    public long getFilterType() {
        return filterType;
    }
}
