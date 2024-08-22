package com.ashen.raiseback.service;

import com.ashen.raiseback.model.Business;
import com.ashen.raiseback.model.Score;
import com.ashen.raiseback.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final BusinessService businessService;

    @Autowired
    public ScoreService( ScoreRepository scoreRepository, BusinessService businessService ) {
        this.scoreRepository = scoreRepository;
        this.businessService = businessService;
    }

    public Score submitScore(long userId, long businessId, short scoreValue) {
        // Check if the score already exists
        Optional<Score> existingScore = scoreRepository.findByBusiness_IdAndUserId(userId, businessId);

        if (existingScore.isPresent()) {
            // Update the existing score
            Score score = existingScore.get();
            score.setScore(scoreValue);
            return scoreRepository.save(score);
        } else {
            // Create a new score
            Optional<Business> businessOptional = businessService.getBusinessById( businessId );
            if (businessOptional.isPresent()){
                Business business = businessOptional.get();
                Score score = new Score(userId, business, scoreValue);
                // Add the score to the business's list of scores
                business.getScores().add(score);
                return scoreRepository.save(score);
            }
            else {
                throw new RuntimeException ("Business with given id was not found");
            }
        }

    }


}
