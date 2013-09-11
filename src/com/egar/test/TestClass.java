package com.egar.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: nchebykina
 * Date: 29.01.13
 * Time: 14:25
 */
public class TestClass {
    private String a;
    private Date b;
    private List<Integer> list;

    public TestClass() {
        a = "abc";
        b = new Date();
        list = new ArrayList<Integer>();
        list.add(17);
        list.add(3);
        list.add(5);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Date getB() {
        return b;
    }

    public void setB(Date b) {
        this.b = b;
    }

    public String getStrB() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(b);
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
