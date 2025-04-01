package model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observateur;


public class ClickerModel implements Observable {
    
    private int score;
    private double scoreIncrements;
    private int priceUpgrade;

    private ArrayList<Observateur> observateurList  = new ArrayList<>();


    public ClickerModel() {
        this.score = 0;
        this.scoreIncrements = 1;
        this.priceUpgrade = 10;

        this.updateObservateur();
    }

    public int getScore() {
        return this.score;
    }

    public double getScoreIncrment() {
        return this.scoreIncrements;
    }

    public int getPriceUpgrade() {
        return this.priceUpgrade;
    }

    public void setScore(int newScore) {
        this.score = newScore;
        this.updateObservateur();
    }

    public void setScoreIncrement(double newScoreIncrement) {
        this.scoreIncrements = newScoreIncrement;
    }

    public void setPriceUpgrade(int newPriceUpgrade) {
        this.priceUpgrade = newPriceUpgrade;
        this.updateObservateur();
    }

    public void addObservateur(Observateur obs) {
        this.observateurList.add(obs);
    }

    public void delObservateur() {
        this.observateurList = new ArrayList<>();
    }

    public void updateObservateur() {
        for (Observateur obs : this.observateurList) {
            obs.update("" + this.score, "" + this.priceUpgrade);
        }
    }

}