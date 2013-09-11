package com.egar.test;

/**
 * User: nchebykina
 * Date: 29.08.13
 * Time: 10:58
 */
public class User extends BaseUser {
    private Integer id;
    private String name;
    private String lang;

    public User(Integer id, String name, String lang) {
        this.id = id;
        this.name = name;
        this.lang = lang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
