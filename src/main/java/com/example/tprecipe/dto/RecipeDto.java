package com.example.tprecipe.dto;

import java.util.Date;

public class RecipeDto {
    int id;
    String name;
    String type;
    int executionTime;
    String details;
    Date dateAdded;
    private String photoUrl;
    public RecipeDto(int id, String name, String type, int executionTime, String details, Date dateAdded, String photoUrl) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.executionTime = executionTime;
        this.details = details;
        this.dateAdded = dateAdded;
        this.photoUrl = photoUrl;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetail(String detail) {
        details = detail;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}


