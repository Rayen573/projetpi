package com.tn.esprit.edtech.repository;

import com.tn.esprit.edtech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

     User findByUsername(String username);


     Boolean existsByUsername(String username);
}
