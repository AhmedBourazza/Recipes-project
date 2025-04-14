package org.system.recipesproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.recipesproject.model.User;
import org.system.recipesproject.repos.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
    public boolean register(String email, String password) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            return false; // utilisateur existe déjà
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password); // idéalement, hash le mot de passe ici
        userRepository.save(newUser);
        return true;
    }

}
