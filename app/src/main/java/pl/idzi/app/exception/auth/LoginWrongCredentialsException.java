package pl.idzi.app.exception.auth;

import pl.idzi.app.exception.UnauthorizedException;

public class LoginWrongCredentialsException extends UnauthorizedException {
    public LoginWrongCredentialsException(String message) {
        super(message);
    }
}
