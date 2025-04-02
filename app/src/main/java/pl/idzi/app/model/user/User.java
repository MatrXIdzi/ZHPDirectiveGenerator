package pl.idzi.app.model.user;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    private String firstname;
    private String surname;
    private String rank;
    private String function;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private Unit unit;


    public User() {
    }

    public User(String firstname, String surname, String email, String username, String password, String rank, String function, UserRole role, Unit unit) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rank = rank;
        this.role = role;
        this.function = function;
        this.unit = unit;
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

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRank() {
        return rank;
    }

    public UserRole getRole() {
        return role;
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

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Unit getUnit() {
        return unit;
    }
}
