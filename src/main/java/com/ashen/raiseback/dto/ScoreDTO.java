package com.ashen.raiseback.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ScoreDTO {

    private long id;
    private long userId;
    private short score;
    private long businessId;

    public ScoreDTO(long id, long user_id, short score, long businessId) {
        this.id = id;
        this.userId = user_id;
        this.score = score;
        this.businessId = businessId;
    }

    public ScoreDTO(){}

    public ScoreDTO(long user_id, short score, long businessId) {
        this.userId = user_id;
        this.score = score;
        this.businessId = businessId;
    }

}
