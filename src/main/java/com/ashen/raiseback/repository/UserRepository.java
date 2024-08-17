package com.ashen.raiseback.repository;

import com.ashen.raiseback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    //New methods
    User getUserByEmail(String email);
}
