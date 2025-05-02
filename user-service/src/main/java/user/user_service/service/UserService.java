package user.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import user.user_service.dto.UserRequest;
import user.user_service.entity.User;
import user.user_service.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .build();
        return userRepository.save(user);
    }
    public boolean userExists(Long id) {
        return userRepository.existsById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
   
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

}