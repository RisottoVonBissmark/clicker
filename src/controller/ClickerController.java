package controller;

import model.ClickerModel;
import observer.Observateur;

public class ClickerController implements Observateur{
    
    ClickerModel model;

    public ClickerController(ClickerModel model) {
        this.model = model;
    }

    public void incrementScore() {
        int score = this.model.getScore();
        double scoreIncrements = this.model.getScoreIncrment();
        
        score += scoreIncrements;

        this.model.setScore(score);
    }

    public void upgrade() {
        int score = this.model.getScore();
        double scoreIncrements = this.model.getScoreIncrment();
        int priceUpgrade = this.model.getPriceUpgrade();
        
        if ( score >= priceUpgrade ) {
            scoreIncrements *= 1.5;
            score -= priceUpgrade;
            priceUpgrade *= 2;
        }

        this.model.setScore(score);
        this.model.setScoreIncrement(scoreIncrements);
        this.model.setPriceUpgrade(priceUpgrade);
    }

    public void update(String prod, String b) {
        int score = this.model.getScore();
        score += Integer.valueOf(prod);
        this.model.setScore(score);
    }
}