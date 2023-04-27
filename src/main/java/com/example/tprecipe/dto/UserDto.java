package com.example.tprecipe.dto;

public class UserDto {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String photo;
    private String password;

    public UserDto(String userEmail, String userPassword) {
        this.email = userEmail;
        this.password = "********";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
