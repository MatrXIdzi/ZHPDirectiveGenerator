package pl.idzi.app.auth;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.idzi.app.auth.dto.LoginRequest;
import pl.idzi.app.auth.dto.RegisterRequest;
import pl.idzi.app.auth.dto.RegisterResponse;
import pl.idzi.app.auth.dto.UserResponse;
import pl.idzi.app.exception.auth.LoginWrongCredentialsException;
import pl.idzi.app.model.user.User;

import pl.idzi.app.exception.auth.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AppUserDetailsService userDetailsService;
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          AppUserDetailsService userDetailsService,
                          AuthService authService,
                          ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest authRequest) throws LoginWrongCredentialsException {
        String token = authService.login( authRequest.getUsername(), authRequest.getPassword());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) throws
            Exception {
        User user = modelMapper.map(registerRequest, User.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(authService.register(user), RegisterResponse.class));
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> me() throws AccountNotFoundException {
        return ResponseEntity.ok(
                modelMapper.map(
                        authService.me(
                                SecurityContextHolder.getContext().getAuthentication().getName()),
                        UserResponse.class));

    }


}

