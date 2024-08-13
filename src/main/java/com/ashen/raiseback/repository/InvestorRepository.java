package com.ashen.raiseback.repository;

import com.ashen.raiseback.model.Investor;
import com.ashen.raiseback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    public Optional<Investor> findByUser( User user );
}
