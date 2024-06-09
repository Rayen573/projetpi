package com.tn.esprit.edtech.controler;

import com.tn.esprit.edtech.entity.User;
import com.tn.esprit.edtech.repository.UserRepository;
import com.tn.esprit.edtech.response.ServerResponse;

import com.tn.esprit.edtech.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/api/users")
public class  UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<ServerResponse> addUser(@RequestBody User user) throws URISyntaxException {
        User addedUser = userService.addUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ServerResponse(HttpStatus.CREATED.getReasonPhrase(), addedUser));
    }

    @GetMapping
    public ResponseEntity<ServerResponse> getAllUsers() throws URISyntaxException {
        List<User> users = userService.getAllUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ServerResponse(HttpStatus.OK.getReasonPhrase(), users));
    }
}
