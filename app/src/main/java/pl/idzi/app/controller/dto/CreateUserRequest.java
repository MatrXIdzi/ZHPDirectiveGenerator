package pl.idzi.app.controller.dto;

import jakarta.validation.constraints.*;

public class CreateUserRequest {
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password is required")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one lowercase letter, one uppercase letter and one digit")
    private String password;

    @NotNull(message = "Firstname cannot be null")
    @NotEmpty(message = "Firstname is required")
    @Size(min = 2, max = 30, message = "Firstname must be between 3 and 30 characters")
    private String firstname;

    @NotNull(message = "Surname cannot be null")
    @NotEmpty(message = "Surname is required")
    @Size(min = 3, max = 30, message = "Surname must be between 3 and 30 characters")
    private String surname;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    public CreateUserRequest(String username, String password, String firstname, String surname, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
}
