package com.egar.test;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: nchebykina
 * Date: 31.07.12
 * Time: 12:29
 */

public class TestMVEL {
    public void test() {

        //Trades
        Trade[] trades = new Trade[5000];
        int i, j;
        for(i = 0; i < 5000; i++) {
            trades[i] = new Trade();
            //System.out.println("trade[" + i + "]\t" + trades[i].getInstrumentClasses());
        }
        //Filters
        Filter[] filters = new Filter[1000];
        for(j = 0; j < 200; j++) filters[j] = new Filter(0);
        for(j = 200; j < 400; j++) filters[j] = new Filter(1);
        for(j = 400; j < 600; j++) filters[j] = new Filter(2);
        for(j = 600; j < 800; j++) filters[j] = new Filter(3);
        for(j = 800; j < 1000; j++) filters[j] = new Filter(4);
        Boolean res = false;
        System.out.println("Start " + Calendar.getInstance().getTime());
        for (i = 0; i < 5000; i++) {
            System.out.print("\rtrade " + i + "         ");
            for (j = 0; j < 1000; j++) {
                /*if(j == 0) System.out.println("\nFilter Type 1 " + Calendar.getInstance().getTimeInMillis());
                if(j == 2000) System.out.println("\nFilter Type 2 " + Calendar.getInstance().getTimeInMillis());
                if(j == 4000) System.out.println("\nFilter Type 3 " + Calendar.getInstance().getTimeInMillis());
                if(j == 6000) System.out.println("\nFilter Type 4 " + Calendar.getInstance().getTimeInMillis());
                if(j == 8000) System.out.println("\nFilter Type 5 " + Calendar.getInstance().getTimeInMillis());*/

                res = (Boolean) MVEL.executeExpression(filters[j].getCompiledExpr(), trades[i]);
                //if (res) System.out.println("true for filter " + j/200);
            }
        }
        System.out.println();
        System.out.println("End " + res + "  " + Calendar.getInstance().getTime());

    }

    public static void main(String[] args) {
//        TestClass tc = new TestClass();
//        System.out.println(tc.getStrB());
//        tc.setB(null);
//        List<String> list = new ArrayList<String>();
//        list.add("17");
//        list.add("3");
//        list.add("5");
//        Map<String, Object> dm = new HashMap<String, Object>();
//        dm.put("OperDate", new Date(1359921600000l));
//        dm.put("l1", "17");
//        dm.put("l2", "4");
//        dm.put("l3", "5");
//        Serializable expr = MVEL.compileExpression("({l1, l2, l3} contains A) &&  B == null");
//        //boolean r = (Boolean)MVEL.eval("a == \"abc\" &&  getB() >= d",tc, dm);
//        boolean r = (Boolean)MVEL.executeExpression(expr,tc, dm);
//        System.out.println(r);
        try {
            //========================================
            // Тестирую проверку полей объекта, находящегося в списке а список - внутри другого объекта
            //========================================
            List<User> users = new ArrayList<User>();
            users.add(new User(1, "us1", "ru"));
            users.add(new User(2, "us2", "ru"));
            users.add(new User(3, "us3", "ru"));
            users.add(new User(4, "us4", "en"));
            users.add(new User(5, "us5", "en"));
            UserContainer uc = new UserContainer();
            uc.setId(11);
            uc.setUsers(users);
            Serializable expr = MVEL.compileExpression("(((id < 3) in users) contains 'cz')");
            boolean r = (Boolean)MVEL.executeExpression(expr,uc);
            System.out.println("r = " + r);
            //========================================
            // Тестирую операции с двумя объектами
            //========================================
            User us =  new User(2, "us2", "ru");
            Map<String, Object> param = new HashMap<String, Object>();
            //param.put("usnew", new User(2, "us2", "ru"));
            param.put("usold", new User(2, "usid", "eng"));
            param.put("param1", 15);
            Serializable expr2 = MVEL.compileExpression("(id == usold.id || name != usold.name) && param1 == 15");
            boolean r2 = (Boolean)MVEL.executeExpression(expr2, us, param);
            System.out.println("r2 = " + r2);
            //========================================
            // Тестирую операции с проверкой объекта на null и обращению к полю объекта
            //========================================
            User us3 = null;
            Map<String, Object> param3 = new HashMap<String, Object>();
            param3.put("current", us3);
            Serializable expr3 = MVEL.compileExpression("current != null && current.id == 1");
            boolean r3 = (Boolean)MVEL.executeExpression(expr3, param3);
            System.out.println("r3 = " + r3);
            //========================================
            // Тестирую случай когда передаётся в выражение объект-предок, а нужно проверять свойства объекта-потомка
            //========================================
            User us4 = new User(4, "us4", "ru");
            BaseUser usBase = us4;
            Map<String, Object> param4 = new HashMap<String, Object>();
            param4.put("us4", usBase);
            Serializable expr4 = MVEL.compileExpression("us4 != null && us4.id == 4 && us4.name == 'us4'");
            boolean r4 = (Boolean)MVEL.executeExpression(expr4, param4);
            System.out.println("r4 = " + r4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

