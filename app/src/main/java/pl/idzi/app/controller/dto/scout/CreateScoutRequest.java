package pl.idzi.app.controller.dto.scout;

import jakarta.validation.constraints.*;

public class CreateScoutRequest {
    @NotNull(message = "Firstname cannot be null")
    @NotEmpty(message = "Firstname is required")
    @Size(min = 2, max = 30, message = "Firstname must be between 2 and 30 characters")
    private String firstname;
    @NotNull(message = "Surname cannot be null")
    @NotEmpty(message = "Surname is required")
    @Size(min = 3, max = 30, message = "Surname must be between 3 and 30 characters")
    private String surname;
    @NotNull(message = "Firstname dative case cannot be null")
    @NotEmpty(message = "Firstname dative case is required")
    @Size(min = 2, max = 30, message = "Firstname dative case must be between 2 and 30 characters")
    private String firstnameDativeCase;
    @NotNull(message = "Surname dative case cannot be null")
    @NotEmpty(message = "Surname dative case is required")
    @Size(min = 3, max = 30, message = "Surname dative case must be between 3 and 30 characters")
    private String surnameDativeCase;
    @NotNull(message = "Rank cannot be null")
    @NotEmpty(message = "Rank is required")
    private String rank;
    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotNull(message = "Phone cannot be null")
    @NotEmpty(message = "Phone is required")
    @Pattern(regexp = "^(\\+\\d{2})?\\d{9}$", message = "Phone must be valid")
    private String phone;

    public CreateScoutRequest() {
    }

    public CreateScoutRequest(String firstname, String surname, String firstnameDativeCase, String surnameDativeCase, String rank, String email, String phone) {
        this.firstname = firstname;
        this.surname = surname;
        this.firstnameDativeCase = firstnameDativeCase;
        this.surnameDativeCase = surnameDativeCase;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
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
