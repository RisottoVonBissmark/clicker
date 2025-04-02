package controller;

import java.util.ArrayList;

import model.FactoryModel;
import observer.Observable;
import observer.Observateur;

public class FactoryController implements Runnable, Observable{
    
    FactoryModel model;
    ArrayList<Observateur> obsList = new ArrayList<>();

    public FactoryController(FactoryModel model) {
        this.model = model;
    }

    public void run(){
        while (true) {
            if (model.canProduce()) {
                this.updateObservateur();
            }
        }
    }

    public void addObservateur(Observateur obs) {
        obsList.add(obs);
    }

    public void delObservateur() {
        obsList = new ArrayList<>();
    }

    public void updateObservateur() {
        for (Observateur obs : obsList) {
            obs.update(this.model.getProduction() + "", null);
        }
    }

}
