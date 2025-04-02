package model;

public class FactoryModel {

    double production;
    double delay;
    int upgradeValue;
    int lastProd;

    public FactoryModel() {
        this.production = 1;
        this.delay = 1;
        this.upgradeValue = 10;
    }
    
    public double getProduction() {
        return this.production;
    }

    public double getDelay() {
        return this.delay;
    }

    public int getUpgradeValue() {
        return this.upgradeValue;
    }

    public void setProduction(double newProduction) {
        this.production = newProduction;
    }

    public void setDelay(double newDelay) {
        this.delay = newDelay;
    }

    public void setUpgradeValue( int newUpgradeValue) {
        this.upgradeValue = newUpgradeValue;
    }

    public boolean canProduce() {
        return System.currentTimeMillis() - lastProd >= delay*1000;
    }
}