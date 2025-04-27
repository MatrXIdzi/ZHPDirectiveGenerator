package pl.idzi.app.auth.dto;

import pl.idzi.app.model.user.UserRole;
import pl.idzi.app.model.user.Unit;

import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String firstname;
    private String surname;
    private String email;
    private String username;
    private String rank;
    private String function;
    private UserRole role;
    private Unit unit;

    public UserResponse() {
    }

    public UserResponse(UUID id, String firstname, String surname, String email, String username, String rank, String function, UserRole role, Unit unit) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.rank = rank;
        this.function = function;
        this.role = role;
        this.unit = unit;
    }

    public UUID getId() { return id; }

    public String getFirstname() { return firstname; }

    public String getSurname() { return surname; }

    public String getEmail() { return email; }

    public String getUsername() { return username; }

    public String getRank() { return rank; }

    public String getFunction() { return function; }

    public UserRole getRole() { return role; }

    public Unit getUnit() { return unit; }

    public void setId(UUID id) { this.id = id; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setEmail(String email) { this.email = email; }

    public void setUsername(String username) { this.username = username; }

    public void setRank(String rank) { this.rank = rank; }

    public void setFunction(String function) { this.function = function; }

    public void setRole(UserRole role) { this.role = role; }

    public void setUnit(Unit unit) { this.unit = unit; }
}
