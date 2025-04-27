package pl.idzi.app.exception.auth;

import pl.idzi.app.exception.NotFoundException;

public class AccountNotFoundException extends NotFoundException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
