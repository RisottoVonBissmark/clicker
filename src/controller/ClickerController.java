package controller;

import model.ClickerModel;

public class ClickerController {
    
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
}