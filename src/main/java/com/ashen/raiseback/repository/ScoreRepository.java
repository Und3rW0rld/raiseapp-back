package com.ashen.raiseback.repository;

import com.ashen.raiseback.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    Optional<Score> findByBusiness_IdAndUserId(long userId, long businessId);
}
