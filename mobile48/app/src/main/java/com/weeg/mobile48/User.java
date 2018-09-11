package com.weeg.mobile48;

public class User {
    String name;
    String lname;
    String pass;

    public User() {
    }

    public User(String name, String lname, String pass) {
        this.name = name;
        this.lname = lname;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
