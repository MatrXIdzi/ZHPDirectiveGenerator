package pl.idzi.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.idzi.app.model.user.User;
import pl.idzi.app.model.user.UserRole;
import pl.idzi.app.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        user.setRole(UserRole.USER);
        if(user.getFirstname().charAt(user.getFirstname().length()-1) == 'a')
            user.setRank("druhna");
        else
            user.setRank("druh");
        user.setFunction(null);
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        User foundUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + user.getId() + " not found"));

        if (!user.getUsername().equals(foundUser.getUsername())) {
            foundUser.setUsername(user.getUsername());
        }
        if (!user.getEmail().equals(foundUser.getEmail())) {
            foundUser.setEmail(user.getEmail());
        }
        if (!user.getPassword().equals(foundUser.getPassword())) {
            foundUser.setPassword(user.getPassword());
        }
        if (!user.getFirstname().equals(foundUser.getFirstname())) {
            foundUser.setFirstname(user.getFirstname());
        }
        if (!user.getSurname().equals(foundUser.getSurname())) {
            foundUser.setSurname(user.getSurname());
        }
        if (!user.getRank().equals(foundUser.getRank())) {
            foundUser.setRank(user.getRank());
        }
        if (!user.getRole().equals(foundUser.getRole())) {
            foundUser.setRole(user.getRole());
        }


        return userRepository.save(foundUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
