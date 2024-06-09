package com.tn.esprit.edtech.service;

import com.tn.esprit.edtech.entity.User;
import com.tn.esprit.edtech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
    List<User> getAllUsers();
}
