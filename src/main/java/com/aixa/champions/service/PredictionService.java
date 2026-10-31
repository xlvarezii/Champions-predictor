
package com.aixa.champions.service;

import com.aixa.champions.dto.PredictionForm;
import com.aixa.champions.model.Match;
import com.aixa.champions.model.Prediction;
import com.aixa.champions.repository.MatchRepository;
import com.aixa.champions.repository.PredictionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {

    private final PredictionRepository predictions;
    private final MatchRepository matches;

    public PredictionService(
            PredictionRepository predictions,
            MatchRepository matches) {
        this.predictions = predictions;
        this.matches = matches;
    }

    public void save(PredictionForm form) {
        Match match = matches.findById(form.getMatchId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Partido inexistente"));

        Integer homeScore = form.getHomeScore();
        Integer awayScore = form.getAwayScore();

        String result;
        if (homeScore.equals(awayScore)) {
            result = "Empate";
        } else if (homeScore > awayScore) {
            result = "Local";
        } else {
            result = "Visitante";
        }

        Prediction prediction = new Prediction(
                match,
                form.getAuthor().trim(),
                result,
                homeScore,
                awayScore
        );

        predictions.save(prediction);
    }

    public List<Prediction> all() {
        return predictions.findAll();
    }
}
