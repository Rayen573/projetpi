package com.tn.esprit.edtech.controler;

import com.tn.esprit.edtech.entity.User;
import com.tn.esprit.edtech.security.JwtUtils;
import com.tn.esprit.edtech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Endpoint pour l'inscription d'un nouvel utilisateur
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        // Vérifie si l'utilisateur existe déjà dans la base de données
        if (userService.getUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists!");
        }

        // Crypte le mot de passe avant de l'enregistrer dans la base de données
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Enregistre l'utilisateur dans la base de données
        userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
    }

    @GetMapping("/test")
    public ResponseEntity<String> Test(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Test");


    }

    // Endpoint pour l'authentification d'un utilisateur
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Récupère l'utilisateur par son nom d'utilisateur
        User user = userService.getUserByUsername(username);

        // Vérifie si l'utilisateur existe et si le mot de passe est correct
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            String jwtToken = jwtUtils.generateJwtToken(new UsernamePasswordAuthenticationToken(username, password));
            // Vous devrez implémenter la logique de génération de jeton JWT ici
            return ResponseEntity.ok("Login successful! JWT Token: <your_generated_token>");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
        }
    }
}
