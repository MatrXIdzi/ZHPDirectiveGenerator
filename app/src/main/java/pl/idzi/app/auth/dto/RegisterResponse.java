package pl.idzi.app.auth.dto;

public class RegisterResponse {
    private String id;
    private String firstName;
    private String surname;
    private String username;
    private String role;

    public RegisterResponse() {
    }

    public RegisterResponse(String id, String firstName, String surname, String username, String role) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
