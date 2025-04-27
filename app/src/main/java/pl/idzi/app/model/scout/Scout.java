package pl.idzi.app.model.scout;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pl.idzi.app.model.AbstractEntity;

import java.util.UUID;


@Entity
public class Scout extends AbstractEntity {

    private String firstname;
    private String surname;
    private String firstnameDativeCase;
    private String surnameDativeCase;
    private String rank;
    private String email;
    private String phone;

    public Scout(String firstname, String surname, String firstnameDativeCase, String surnameDativeCase, String rank, String email, String phone) {
        this.firstname = firstname;
        this.surname = surname;
        this.firstnameDativeCase = firstnameDativeCase;
        this.surnameDativeCase = surnameDativeCase;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
    }

    public Scout() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstnameDativeCase() {
        return firstnameDativeCase;
    }

    public void setFirstnameDativeCase(String firstnameDativeCase) {
        this.firstnameDativeCase = firstnameDativeCase;
    }

    public String getSurnameDativeCase() {
        return surnameDativeCase;
    }

    public void setSurnameDativeCase(String surnameDativeCase) {
        this.surnameDativeCase = surnameDativeCase;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
