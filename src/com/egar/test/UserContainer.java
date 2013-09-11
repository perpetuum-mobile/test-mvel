package com.egar.test;

import java.util.List;

/**
 * User: nchebykina
 * Date: 29.08.13
 * Time: 11:00
 */
public class UserContainer {
    private Integer id;
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
