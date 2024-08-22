package com.ashen.raiseback.controller;

import com.ashen.raiseback.dto.ScoreDTO;
import com.ashen.raiseback.model.Business;
import com.ashen.raiseback.model.Score;
import com.ashen.raiseback.service.BusinessService;
import com.ashen.raiseback.service.ScoreService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/businesses")
public class ScoreController {

    private final BusinessService businessService;
    private final ScoreService scoreService;

    @Autowired
    public ScoreController ( BusinessService businessService, ScoreService scoreService ) {
        this.businessService = businessService;
        this.scoreService = scoreService;
    }

    @PostMapping("/{id}/scores")
    public ResponseEntity<Score> addScore(@PathVariable Long id, @RequestBody ScoreDTO scoreDTO) {
        Business business = businessService.getBusinessById(id)
                .orElseThrow(() -> new EntityNotFoundException("Business not found"));
        Score savedScore = scoreService.submitScore(scoreDTO.getUserId(), scoreDTO.getBusinessId(), scoreDTO.getScore());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScore);
    }

}
