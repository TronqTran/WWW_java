package vn.edu.iuh.lab_06.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_06.models.User;
import vn.edu.iuh.lab_06.repositories.UserRepository;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String register(User user){
        Optional<User> result = userRepository.findUserByEmail(user.getEmail());
        if(result.isPresent()) return "This email has been already token";

        userRepository.save(user);

        return "";
    }

    public Optional<User> login(User user){
        return userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    public void updateLoginTime(User user){
        user.setLastLogin(Instant.now());
        userRepository.save(user);
    }

    public Optional<User>findById(long id){
        return userRepository.findById(id);
    }
}