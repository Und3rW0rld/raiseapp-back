package com.ashen.raiseback.repository;

import com.ashen.raiseback.model.Entrepreneur;
import com.ashen.raiseback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepreneurRepository extends JpaRepository<Entrepreneur, Long> {
    public Optional<Entrepreneur> findByUser( User user );
    public Optional<Entrepreneur> findByUser_Id( long userId );
}
