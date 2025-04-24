import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.ClickerButtonListener;

public class Usine {
    
    int production;
    long lastProduct;
    int level;
    int delay;
    int upgradePrice;
    boolean waitUpgrade;

    JPanel usinePanel;
    JPanel infoPanel;

    JLabel productionLabel;
    JLabel leveLabel;

    JButton upgraButton;

    public Usine() {

        this.production = 5;
        this.lastProduct = System.currentTimeMillis();
        this.delay = 1000;
        this.upgradePrice = 500;

        this.initView();
    }

    public int product() {
        if ((this.lastProduct + this.delay) > System.currentTimeMillis()) {
            return 0;
        }

        this.lastProduct = System.currentTimeMillis();
        return this.production;
        
    }

    private void initView() {

        this.usinePanel = new JPanel();

        this.upgraButton = new JButton();
        this.upgraButton.addActionListener(new ClickerButtonListener<>(() -> setWaitingUpgrade(true)));

        this.usinePanel.add(upgraButton);

        this.infoPanel = new JPanel();
        this.infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        this.productionLabel = new JLabel();
        this.leveLabel = new JLabel();
        
        this.infoPanel.add(productionLabel);
        this.infoPanel.add(leveLabel);

        this.usinePanel.add(infoPanel);

        this.usinePanel.setAlignmentX(Component.TOP_ALIGNMENT);

        updateLabels();
    }

    private void updateLabels() {
        
        this.productionLabel.setText("Production: " + this.production);
        this.leveLabel.setText("Level :" + this.level);
        
        this.upgraButton.setText(this.upgradePrice + "");

    }

    public int setWaitingUpgrade(boolean waitingUpgrade) {
        
        this.waitUpgrade = waitingUpgrade;
        return 0;
    }

    public boolean isWaitingUpgrade() {
        return this.waitUpgrade;
    }

    public void upgrade() {
        this.level += 1;
        this.production *= 1.5;
        this.upgradePrice *= 2;

        updateLabels();
    }

    public JPanel getPanel() {
        return this.usinePanel;
    }

    public int getUpgradePrice() {
        return this.upgradePrice;
    }

}
