package pl.idzi.app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.idzi.app.controller.dto.CreateUserRequest;
import pl.idzi.app.controller.dto.UserResponse;
import pl.idzi.app.model.user.User;
import pl.idzi.app.model.user.UserRole;
import pl.idzi.app.service.UserService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userService;
    ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponse> responses = users.stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());

        System.out.println(responses);

        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {

        User user = modelMapper.map(createUserRequest, User.class);
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(newUser, UserResponse.class));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(user, UserResponse.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(user, UserResponse.class));
    }
}
