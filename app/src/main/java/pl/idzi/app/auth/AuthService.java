package pl.idzi.app.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.idzi.app.exception.auth.LoginWrongCredentialsException;
import pl.idzi.app.model.user.User;
import pl.idzi.app.model.user.UserRole;
import pl.idzi.app.service.UserService;

import pl.idzi.app.exception.auth.AccountNotFoundException;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AppUserDetailsService userDetailsService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager,
                       JwtService jwtService,
                       AppUserDetailsService userDetailsService,
                       UserService userService,
                       PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    public User me(String login) throws
            AccountNotFoundException {
        return userService.getUserByUsername(login)
                .orElseThrow(() -> new AccountNotFoundException("User with login '" + login + "' not found"));
    }

    public User register(User user) throws
            Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.USER);
        return userService.saveUser(user);
    }

    public String login(String username, String password) throws LoginWrongCredentialsException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (AuthenticationException e) {
            throw new LoginWrongCredentialsException("login.wrongCredentials");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtService.generateToken(userDetails);
    }
}
