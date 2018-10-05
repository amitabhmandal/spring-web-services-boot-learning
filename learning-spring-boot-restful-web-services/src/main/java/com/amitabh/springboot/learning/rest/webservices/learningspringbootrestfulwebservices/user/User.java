package com.amitabh.springboot.learning.rest.webservices.learningspringbootrestfulwebservices.user;

import java.util.Date;

public class User {
    public User() {
    }
    private int id;
    private String name;
    private Date birthDate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public User(int id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
