
package com.aixa.champions.dto;

import jakarta.validation.constraints.*;

public class PredictionForm {

    @NotNull
    private Long matchId;

    @NotBlank
    @Size(max = 80)
    private String author;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer homeScore;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer awayScore;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }
}


