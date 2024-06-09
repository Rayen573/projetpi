package com.tn.esprit.edtech.service;

import com.tn.esprit.edtech.entity.User;
import com.tn.esprit.edtech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

@Autowired
    private UserRepository userRepository;

@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(User user) {
        // Vérifiez si l'utilisateur existe déjà dans la base de données
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists!");
        }

        // Cryptez le mot de passe avant de l'enregistrer dans la base de données
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Enregistrez l'utilisateur dans la base de données
        return userRepository.save(user);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    // Ajoutez d'autres méthodes de service au besoin
}
