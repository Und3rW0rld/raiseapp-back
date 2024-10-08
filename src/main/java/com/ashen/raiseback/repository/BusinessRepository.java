package com.ashen.raiseback.repository;

import com.ashen.raiseback.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findByEntrepreneur_Id ( long id );
}
