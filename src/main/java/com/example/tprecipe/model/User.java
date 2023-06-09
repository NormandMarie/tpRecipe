package com.example.tprecipe.model;

public class User {
    private int id;
    private String firstname;
    private  String lastname;
    private String email;
    private String picture;
    private String password;

    public User(int id, String firstname, String lastname, String email, String picture, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.picture = picture;
        this.password = password;
    }

    public User(String firstname, String lastname, String email, String picture) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.picture = picture;
    }

    public User(String nom, String prenom, String email, String photo, String password) {
        this.firstname = prenom;
        this.lastname = nom;
        this.email = email;
        this.picture = photo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
