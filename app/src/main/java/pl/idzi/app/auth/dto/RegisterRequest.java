package pl.idzi.app.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @NotBlank(message = "Imię jest wymagane")
    private String firstname;

    @NotBlank(message = "Nazwisko jest wymagane")
    private String surname;

    @NotBlank(message = "Email jest wymagany")
    @Email(message = "Nieprawidłowy email")
    private String email;

    @NotBlank(message = "Nazwa użytkownika jest wymagana")
    private String username;

    @NotBlank(message = "Hasło jest wymagane")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 6 znaków")
    private String password;

    public RegisterRequest() {
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}