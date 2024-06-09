package com.tn.esprit.edtech.repository;

import com.tn.esprit.edtech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

     Optional<User> findByEmail(String email);
}
