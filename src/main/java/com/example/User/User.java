package com.example.User;

public class User {
    private int id;
    private String name;
    private String password;
    private String mail;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User(int id, String name, String mail, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public User(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
