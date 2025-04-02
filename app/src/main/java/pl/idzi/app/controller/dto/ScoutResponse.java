package pl.idzi.app.controller.dto;

import java.util.UUID;

public class ScoutResponse {
    private UUID id;
    private String firstname;
    private String surname;
    private String firstnameDativeCase;
    private String surnameDativeCase;
    private String rank;
    private String email;
    private String phone;

    public ScoutResponse(UUID id, String firstname, String surname, String firstnameDativeCase, String surnameDativeCase, String rank, String email, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.firstnameDativeCase = firstnameDativeCase;
        this.surnameDativeCase = surnameDativeCase;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
    }

    public ScoutResponse() {
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstnameDativeCase() {
        return firstnameDativeCase;
    }

    public String getSurnameDativeCase() {
        return surnameDativeCase;
    }

    public String getRank() {
        return rank;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstnameDativeCase(String firstnameDativeCase) {
        this.firstnameDativeCase = firstnameDativeCase;
    }

    public void setSurnameDativeCase(String surnameDativeCase) {
        this.surnameDativeCase = surnameDativeCase;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
